package com.microservice.productservice.web.api;

import com.microservice.productservice.business.service.ProductService;
import com.microservice.productservice.web.dto.ProductRequest;
import com.microservice.productservice.web.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

   private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request) {
        productService.createProduct(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> createProduct() {
      return productService.getProducts().stream().map(ProductResponse::new).toList();
    }
}
