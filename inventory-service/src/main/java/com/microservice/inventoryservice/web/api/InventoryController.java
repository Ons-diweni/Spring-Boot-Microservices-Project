package com.microservice.inventoryservice.web.api;

import com.microservice.inventoryservice.business.service.InventoryService;
import com.microservice.inventoryservice.web.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
     return inventoryService.isInStock(skuCode);
    }
}
