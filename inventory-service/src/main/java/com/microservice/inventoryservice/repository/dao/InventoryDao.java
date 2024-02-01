package com.microservice.inventoryservice.repository.dao;

import com.microservice.inventoryservice.repository.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryDao extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBySkuCode (String skuCode);
}
