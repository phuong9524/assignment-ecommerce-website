package com.nashtech.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.entities.ProductInventory;
import com.nashtech.backend.data.entities.Rating;
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

    @NotBlank(message = "Product image is required")
    private String image;

    private ProductCategory productCategory;

    private ProductInventory productInventory;


    @JsonCreator
    public ProductUpdateDto(
            @JsonProperty("name") String name,
            @JsonProperty("desc") String desc,
            @JsonProperty("price") Double price,
            @JsonProperty("image") String image,
            @JsonProperty("productCategory") ProductCategory productCategory,
            @JsonProperty("productInventory") ProductInventory productInventory) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.image = image;
        this.productCategory = productCategory;
        this.productInventory = productInventory;
    }


}
