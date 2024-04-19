package com.ra.api.service.impl;

import com.ra.api.entity.ProductEntity;
import com.ra.api.repository.ProductRepository;
import com.ra.api.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> findByKey(String key, Integer batch) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (key != null) {
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("productId"), "%"+key+"%"),
                        criteriaBuilder.like(root.get("productName"), "%"+key+"%"),
                        criteriaBuilder.like(root.get("manufacturer"), "%"+key+"%")
                ));
            }
            if (batch != null) {
                predicates.add(criteriaBuilder.equal(root.get("batch"), batch));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    @Override
    public List<ProductEntity> findByExample(ProductEntity productEntity) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withMatcher("batch", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<ProductEntity> example = Example.of(productEntity, matcher);

        return productRepository.findAll(example);
    }

    @Override
    public ProductEntity add(ProductEntity entity) {
        return productRepository.save(entity);
    }
}
