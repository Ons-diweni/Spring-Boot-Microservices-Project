package com.microservice.orderservice.business.client.inventory;

import com.microservice.orderservice.business.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InventoryClient {

    private final WebClient.Builder webClientBuilder;

    public boolean isInStock(List<String> skuCodes) {
        List<InventoryResponse> inventoryResponses = Arrays.stream(webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventories", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block()).toList();
        return inventoryResponses.stream().allMatch(InventoryResponse::isInStock);
    }
}
