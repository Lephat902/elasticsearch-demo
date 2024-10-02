package com.phatle.elastic_search_demo.common.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
    @Min(1)
    protected int page = 1;
    @Min(1)
    @Max(20)
    protected int limit = 10;
}
