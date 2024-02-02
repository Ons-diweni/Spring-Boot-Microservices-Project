package com.microservice.productservice.business.service;

import com.microservice.productservice.business.service.ProductService;
import com.microservice.productservice.repository.dao.ProductDao;
import com.microservice.productservice.repository.model.Product;
import com.microservice.productservice.web.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    public void createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description((request.getDescription()))
                .price(request.getPrice())
                .build();
        productDao.save(product);
        log.info("product {} saved successfully", product.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
    }
}
