package com.phatle.elastic_search_demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phatle.elastic_search_demo.es_entity.Product;
import com.phatle.elastic_search_demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
