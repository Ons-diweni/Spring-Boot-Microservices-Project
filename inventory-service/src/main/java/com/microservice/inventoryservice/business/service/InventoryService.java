package com.microservice.inventoryservice.business.service;

import com.microservice.inventoryservice.web.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> isInStock(List<String> skuCodes);
}
