package com.nashtech.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@NoArgsConstructor
public class ProductUpdateDto {

    @NotBlank(message = "Product name is required")
    private String name;

    private String desc;

    @Min(value = 1, message = "Price should be a positive number")
    private Double price;


    @JsonCreator
    public ProductUpdateDto(
            @JsonProperty("name") String name,
            @JsonProperty("desc") String desc,
            @JsonProperty("price") Double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }


}
