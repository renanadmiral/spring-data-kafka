package com.letscode.validator.service;

import com.letscode.validator.dto.customer.CustomerDTO;
import com.letscode.validator.dto.product.ProductDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductService {
    public static ProductDTO getProduct(String id) {
        WebClient webClient = WebClient.create("http://localhost:8081");

        return webClient
                .get()
                .uri("/product/{id}", id)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }
}
