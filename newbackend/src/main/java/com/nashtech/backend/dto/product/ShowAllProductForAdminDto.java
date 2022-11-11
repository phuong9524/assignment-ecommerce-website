package com.nashtech.backend.dto.product;

import com.nashtech.backend.dto.AuditDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ShowAllProductForAdminDto extends AuditDto {

    final Integer id;

    final String name;

    final Double price;

    final String image;

    final String categoryName;

}
