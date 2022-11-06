package com.nashtech.backend.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ShowAllProductForUserDto {

    final Integer id;

    final String name;

    final String desc;

    final Double price;

    final String image;

    final String categoryName;

}
