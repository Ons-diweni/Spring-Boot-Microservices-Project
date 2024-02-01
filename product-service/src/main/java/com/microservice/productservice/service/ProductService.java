package com.microservice.productservice.service;

import com.microservice.productservice.repository.model.Product;
import com.microservice.productservice.web.dto.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void createProduct(ProductRequest request);
    List<Product> getProducts();
}
