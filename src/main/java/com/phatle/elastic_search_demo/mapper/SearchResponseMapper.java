package com.phatle.elastic_search_demo.mapper;

import java.util.List;

import co.elastic.clients.elasticsearch.core.SearchResponse;

public class SearchResponseMapper {
    public static <T> List<T> extractItems(SearchResponse<T> searchResponse) {
        return searchResponse.hits().hits().stream()
                .map(hit -> hit.source())
                .toList();
    }
}
