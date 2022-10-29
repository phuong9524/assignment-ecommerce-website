package com.nashtech.backend.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter

public class CategoryRequestDto {

    @NotBlank
    private String categoryName;

    private String categoryDesc;
}
