package com.phatle.elastic_search_demo.entity;

import java.time.Instant;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String description;
    private double price;
    @UpdateTimestamp
    private Instant modificationTime;
}