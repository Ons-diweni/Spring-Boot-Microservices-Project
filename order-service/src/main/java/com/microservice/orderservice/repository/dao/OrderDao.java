package com.microservice.orderservice.repository.dao;

import com.microservice.orderservice.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
