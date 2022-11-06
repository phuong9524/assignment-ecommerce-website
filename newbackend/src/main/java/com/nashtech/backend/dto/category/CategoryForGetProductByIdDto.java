package com.nashtech.backend.dto.category;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryForGetProductByIdDto {

    private final String categoryName;

    private final String categoryDesc;

}
