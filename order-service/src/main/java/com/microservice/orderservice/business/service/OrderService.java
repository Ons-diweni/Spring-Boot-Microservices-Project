package com.microservice.orderservice.business.service;

import com.microservice.orderservice.web.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
