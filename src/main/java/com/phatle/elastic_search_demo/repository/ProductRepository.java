package com.phatle.elastic_search_demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.phatle.elastic_search_demo.es_entity.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
