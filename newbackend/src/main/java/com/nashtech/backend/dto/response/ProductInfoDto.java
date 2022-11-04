package com.nashtech.backend.dto.response;

import com.nashtech.backend.data.entities.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoDto {
    private Integer id;
    private String name;
    private String desc;
    private Double price;
    private String image;
    private ProductCategory productCategory;

}

