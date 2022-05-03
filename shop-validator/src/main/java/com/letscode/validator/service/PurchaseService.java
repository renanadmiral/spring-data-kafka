package com.letscode.validator.service;

import com.letscode.validator.dto.product.ProductDTO;
import com.letscode.validator.dto.request.RequestPurchaseDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class PurchaseService {
    public static ProductDTO postPurchase(RequestPurchaseDTO requestPurchaseDTO) {
        WebClient webClient = WebClient.create("http://localhost:8081");

        return webClient
                .post()
                .uri("/purchase/save", requestPurchaseDTO)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }
}
