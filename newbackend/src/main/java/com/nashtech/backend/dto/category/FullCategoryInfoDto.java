package com.nashtech.backend.dto.category;

import com.nashtech.backend.dto.AuditDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class FullCategoryInfoDto extends AuditDto {

    final Integer id;

    final String categoryName;

    final String categoryDesc;
}
