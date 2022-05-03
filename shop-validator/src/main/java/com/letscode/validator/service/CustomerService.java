package com.letscode.validator.service;

import com.letscode.validator.dto.customer.CustomerDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class CustomerService {

    public static CustomerDTO getCustomer(String registrationNumber) {
        WebClient webClient = WebClient.create("http://localhost:8081");

        return webClient
                .get()
                .uri("/customer/{cpf}", registrationNumber)
                .retrieve()
                .bodyToMono(CustomerDTO.class)
                .block();
    }
}
