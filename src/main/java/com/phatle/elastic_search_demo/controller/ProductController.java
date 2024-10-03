package com.phatle.elastic_search_demo.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phatle.elastic_search_demo.dto.AddProductDto;
import com.phatle.elastic_search_demo.dto.ProductQueryDto;
import com.phatle.elastic_search_demo.entity.Product;
import com.phatle.elastic_search_demo.entity.ProductES;
import com.phatle.elastic_search_demo.service.ProductService;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody AddProductDto product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Optional<ProductES> getProductById(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping
    public Iterable<ProductES> getAllProducts(@Valid ProductQueryDto productQueryDto) throws ElasticsearchException, IOException {
        return productService.findAll(productQueryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }
}
