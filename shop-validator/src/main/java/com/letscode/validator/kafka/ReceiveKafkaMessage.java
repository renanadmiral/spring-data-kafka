package com.letscode.validator.kafka;

import com.letscode.validator.dto.customer.CustomerDTO;
import com.letscode.validator.dto.request.RequestPurchaseDTO;
import com.letscode.validator.service.CustomerService;
import com.letscode.validator.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {


    public static final String KAFKA_TOPIC = "SHOP_QUEUE";

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void listenTopic(RequestPurchaseDTO purchaseDTO) {



        CustomerDTO customer = CustomerService.getCustomer(purchaseDTO.getCustomerRegistration());
        if (customer == null) {
            assert customer != null;
            if (customer.getRegistrationNumber() != null) {
                throw new RuntimeException("Customer not found.");
            }
        }
        ;

        System.out.println("Compra processada: " + customer.getRegistrationNumber());


        PurchaseService.postPurchase(purchaseDTO);
    }

}
