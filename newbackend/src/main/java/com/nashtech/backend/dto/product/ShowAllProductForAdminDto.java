package com.nashtech.backend.dto.product;

import com.nashtech.backend.dto.AuditDto;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ShowAllProductForAdminDto extends AuditDto {

    final Integer id;

    final String name;

    final String desc;

    final Double price;

    final String image;

    final String categoryName;

    final Double avgRate;
}
