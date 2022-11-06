package com.nashtech.backend.dto.rating;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class ProductRatingRequestDto {

    @NotNull
    final Double rate;

    final String comment;

    final String username;

    final Integer productId;

}

