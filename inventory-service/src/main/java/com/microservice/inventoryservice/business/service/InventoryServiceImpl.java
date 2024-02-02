package com.microservice.inventoryservice.business.service;

import com.microservice.inventoryservice.repository.dao.InventoryDao;
import com.microservice.inventoryservice.web.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryDao inventoryDao;

    @Transactional(readOnly = true)
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryDao.findBySkuCodeIn(skuCodes).stream().map(inventory -> InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .inStock(inventory.getQuantity()>0)
                .build()).toList();
    }
}
