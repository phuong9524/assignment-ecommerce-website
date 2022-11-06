package com.nashtech.backend.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class GetProductByIdDto {

    final Integer id;

    final String name;

    final String desc;

    final Double price;

    final String image;

    final String categoryDesc;

    final Double avgRate;

}
