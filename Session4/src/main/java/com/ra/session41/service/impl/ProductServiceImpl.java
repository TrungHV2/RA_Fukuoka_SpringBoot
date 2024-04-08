package com.ra.session41.service.impl;

import com.ra.session41.model.ProductRequest;
import com.ra.session41.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductRequest add(ProductRequest productRequest) {
        productRequest.setId(UUID.randomUUID().toString());
        return productRequest;
    }
}