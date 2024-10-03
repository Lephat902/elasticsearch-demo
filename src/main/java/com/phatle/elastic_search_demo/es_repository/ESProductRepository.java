package com.phatle.elastic_search_demo.es_repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.phatle.elastic_search_demo.entity.ProductES;

public interface ESProductRepository extends ElasticsearchRepository<ProductES, String> {
}
