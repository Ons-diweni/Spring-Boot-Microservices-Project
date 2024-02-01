package com.microservice.inventoryservice.service;

import com.microservice.inventoryservice.repository.dao.InventoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryDao inventoryDao;

    @Transactional(readOnly = true)
    @Override
    public boolean isInStock(String skuCode) {
        return inventoryDao.findBySkuCode(skuCode).isPresent();
    }
}
