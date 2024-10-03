package com.phatle.elastic_search_demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.phatle.elastic_search_demo.dto.AddProductDto;
import com.phatle.elastic_search_demo.entity.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityDTOMapper {
    @Mapping(target = "id", ignore = true)
    Product toEntity(AddProductDto dto);

    AddProductDto toDTO(Product product);
    List<AddProductDto> toDTOs(List<Product> products);
}
