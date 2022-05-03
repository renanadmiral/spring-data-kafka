package br.com.letscode.dataproject.purchase.kafka;

import br.com.letscode.dataproject.purchase.dto.request.RequestPurchaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessage {

    private final KafkaTemplate<String, RequestPurchaseDTO> kafkaTemplate;

    public static final String KAFKA_TOPIC = "SHOP_QUEUE";

    public RequestPurchaseDTO sendMessage(RequestPurchaseDTO compra) {
        kafkaTemplate.send(KAFKA_TOPIC, compra);
        return compra;
    }

}
