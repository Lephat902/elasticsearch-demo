package com.phatle.elastic_search_demo.es_entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "products")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
}