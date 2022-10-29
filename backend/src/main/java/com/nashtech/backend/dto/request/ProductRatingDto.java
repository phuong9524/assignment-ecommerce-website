package com.nashtech.backend.dto.request;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class ProductRatingDto {
    @NotBlank(message = "rating is required")
    private Double rate;

    private String comment;

    private User user;

    private Product product;

}
