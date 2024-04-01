package com.ra.api.controller;

import com.ra.api.entity.ProductsEntity;
import com.ra.api.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductsEntity> get() {
        return productRepository.findAll();
    }
    @PostMapping
    public ProductsEntity post(@RequestBody ProductsEntity entity) {
        return productRepository.save(entity);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductsEntity> put(@PathVariable("id") String id, @RequestBody ProductsEntity entity) {
        if (productRepository.findById(id).orElse(null) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productRepository.save(entity), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductsEntity> put(@PathVariable("id") String id) {
        ProductsEntity product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        productRepository.delete(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
