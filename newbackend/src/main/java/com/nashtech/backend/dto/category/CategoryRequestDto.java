package com.nashtech.backend.dto.category;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CategoryRequestDto {

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDesc;

}

