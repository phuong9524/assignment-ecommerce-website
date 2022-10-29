package com.nashtech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;


public class ProductResponseDto extends ProductInfoDto {
    final String creationDate;
    final String lastModifiedDate;

    @Builder()
    @JsonCreator
    public ProductResponseDto(
            @JsonProperty("name") final String name,
            @JsonProperty("desc") final String desc,
            @JsonProperty("price") final Double price,
            @JsonProperty("image") final String image,
            @JsonProperty("creationDate") final String creationDate,
            @JsonProperty("lastModifiedDate") final String lastModifiedDate) {
        super(name, desc, price, image);
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
    }


}
