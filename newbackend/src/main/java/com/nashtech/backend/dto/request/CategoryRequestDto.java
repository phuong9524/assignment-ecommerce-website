package com.nashtech.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CategoryRequestDto {

    @NotBlank
    private final String categoryName;

    private final String categoryDesc;

    @JsonCreator
    public CategoryRequestDto(
            @JsonProperty("categoryName") String categoryName,
            @JsonProperty("categoryDesc") String categoryDesc) {
        this.categoryDesc = categoryDesc;
        this.categoryName = categoryName;
    }
}

