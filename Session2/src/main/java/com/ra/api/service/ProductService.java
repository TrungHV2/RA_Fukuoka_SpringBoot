package com.ra.api.service;

import com.ra.api.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findByKey(String key, Integer batch);
    List<ProductEntity> findByExample(ProductEntity productEntity);
}
