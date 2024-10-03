package com.phatle.elastic_search_demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phatle.elastic_search_demo.dto.AddProductDto;
import com.phatle.elastic_search_demo.dto.ProductQueryDto;
import com.phatle.elastic_search_demo.entity.Product;
import com.phatle.elastic_search_demo.entity.ProductES;
import com.phatle.elastic_search_demo.es_repository.ESProductRepository;
import com.phatle.elastic_search_demo.mapper.EntityDTOMapper;
import com.phatle.elastic_search_demo.mapper.SearchResponseMapper;
import com.phatle.elastic_search_demo.repository.ProductRepository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.json.JsonData;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ESProductRepository esProductRepository;
    private final ElasticsearchClient elasticsearchClient;
    private final EntityDTOMapper entityDTOMapper;

    public Product save(AddProductDto product) {
        var productToSave = entityDTOMapper.toEntity(product);
        return productRepository.save(productToSave);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
        esProductRepository.deleteById(id);
    }

    public Optional<ProductES> findById(String id) {
        return esProductRepository.findById(id);
    }

    public Iterable<ProductES> findAll(ProductQueryDto queryDto) throws ElasticsearchException, IOException {
        var boolQuery = QueryBuilders.bool();

        addQuery(boolQuery, queryDto);
        addPriceFilters(boolQuery, queryDto);

        var page = queryDto.getPage() - 1;
        var limit = queryDto.getLimit();

        var searchRequest = SearchRequest.of(s -> s
                .index("products")
                .query(boolQuery.build()._toQuery())
                .from(page * limit)
                .size(limit));

        var searchResponse = elasticsearchClient.search(searchRequest, ProductES.class);

        return SearchResponseMapper.extractItems(searchResponse);
    }

    private void addQuery(BoolQuery.Builder boolQuery, ProductQueryDto queryDto) {
        if (queryDto.getQ() != null && !queryDto.getQ().isEmpty()) {
            boolQuery.must(QueryBuilders.multiMatch(m -> m
                    .query(queryDto.getQ())
                    .fields("name", "description")
                    .fuzziness("AUTO")));
        }
    }

    private void addPriceFilters(BoolQuery.Builder boolQuery, ProductQueryDto queryDto) {
        if (queryDto.getMinPrice() != null) {
            boolQuery.filter(QueryBuilders.range(r -> r
                    .field("price")
                    .gte(JsonData.of(queryDto.getMinPrice()))));
        }

        if (queryDto.getMaxPrice() != null) {
            boolQuery.filter(QueryBuilders.range(r -> r
                    .field("price")
                    .lte(JsonData.of(queryDto.getMaxPrice()))));
        }
    }
}
