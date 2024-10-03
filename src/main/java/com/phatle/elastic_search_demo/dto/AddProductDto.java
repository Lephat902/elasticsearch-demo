package com.phatle.elastic_search_demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @Min(0)
    private double price;
}
