package com.nashtech.backend.dto.rating;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class ProductRatingRequestDto {

    @NotNull
    private Double rate;

    private String username;

    private Integer productId;

}

