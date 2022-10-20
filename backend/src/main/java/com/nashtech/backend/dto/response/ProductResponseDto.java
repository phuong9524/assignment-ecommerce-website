package com.nashtech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import lombok.Builder;


public class ProductResponseDto extends ProductInfoDto {
    final String creationDate;
    final String lastModifiedDate;

    @Builder(builderMethodName = "builder")
    @JsonCreator
    private ProductResponseDto(
            @JsonProperty("name") final String name,
            @JsonProperty("desc") final String desc,
            @JsonProperty("price") final Double price,
            @JsonProperty("creationDate") final String creationDate,
            @JsonProperty("lastModifiedDate") final String lastModifiedDate) {
        super(name, desc, price);
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
    }


}
