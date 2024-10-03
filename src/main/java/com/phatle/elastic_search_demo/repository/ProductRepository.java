package com.phatle.elastic_search_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phatle.elastic_search_demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}