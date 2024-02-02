package com.microservice.orderservice.business.service;

import com.microservice.orderservice.business.client.inventory.InventoryClient;
import com.microservice.orderservice.repository.dao.OrderDao;
import com.microservice.orderservice.repository.model.Order;
import com.microservice.orderservice.repository.model.OrderLineItems;
import com.microservice.orderservice.web.dto.OrderLineItemsDto;
import com.microservice.orderservice.web.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final InventoryClient inventoryClient;

    @Transactional
    @Override
    public void placeOrder(OrderRequest orderRequest) {

        List<String> skuCodes = orderRequest.getOrderLineItemsList().stream().map(OrderLineItemsDto::getSkuCode).toList();

        //call the  inventory service to check if the product is in stock or not
        boolean inStock = inventoryClient.isInStock(skuCodes);

        if (inStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsList().stream().map(orderLineItemsDto -> OrderLineItems.builder().skuCode(orderLineItemsDto.getSkuCode()).price(orderLineItemsDto.getPrice()).quantity(orderLineItemsDto.getQuantity()).build()).toList();
            order.setOrderLineItemsList(orderLineItemsList);
            orderDao.save(order);
        } else {
            throw new IllegalArgumentException("This product is out of stock !");
        }
    }
}
