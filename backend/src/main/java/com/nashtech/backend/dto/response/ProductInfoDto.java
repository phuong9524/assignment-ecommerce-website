package com.nashtech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class ProductInfoDto {
    private String name;
    private String desc;
    private Double price;
    
    public ProductInfoDto(String name, String desc, Double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
}
