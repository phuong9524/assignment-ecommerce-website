package com.nashtech.backend.dto.product;

import lombok.Getter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
public class ProductRequestDto {

    @NotBlank(message = "Product name is required")
    private String name;

    private String desc;

    @Min(value = 1, message = "Price should be a positive number")
    private Double price;

    @NotBlank(message = "Product image is required")
    private String image;

    private String categoryName;

}
