package com.microservice.productservice.repository.dao;

import com.microservice.productservice.repository.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProductDao extends MongoRepository<Product, String> {
}
