package com.nashtech.backend.dto.product;

import com.nashtech.backend.dto.AuditDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
public class ShowLatestProductsDto extends AuditDto{

    final Integer id;

    final String name;

    final String desc;

    final Double price;

    final String image;

}

