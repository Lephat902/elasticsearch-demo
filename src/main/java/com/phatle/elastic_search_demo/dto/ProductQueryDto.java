package com.phatle.elastic_search_demo.dto;

import org.springdoc.core.annotations.ParameterObject;

import com.phatle.elastic_search_demo.common.dto.PaginationDto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ParameterObject
public class ProductQueryDto extends PaginationDto {
    @Parameter
    private String q;

    @Min(0)
    @Parameter
    private Integer minPrice;

    @Min(0)
    @Parameter
    private Integer maxPrice;
}
