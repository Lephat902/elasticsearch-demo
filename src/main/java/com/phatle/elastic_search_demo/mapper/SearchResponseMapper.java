package com.phatle.elastic_search_demo.mapper;

import java.util.List;

import com.phatle.elastic_search_demo.entity.Identifiable;

import co.elastic.clients.elasticsearch.core.SearchResponse;

public class SearchResponseMapper {
    public static <T extends Identifiable> List<T> extractItems(SearchResponse<T> searchResponse) {
        return searchResponse.hits().hits().stream()
                .map(hit -> {
                    T source = hit.source();
                    source.setId(hit.id()); // Set the id field from the _id
                    return source;
                })
                .toList();
    }
}
