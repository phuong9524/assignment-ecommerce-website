package com.nashtech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class RatingResponseDto {

    private Double rate;

    private String comment;

    private Product product;

    private User user;

    @JsonCreator
    public RatingResponseDto(
            @JsonProperty("rate") Double rate,
            @JsonProperty("comment") String comment,
            @JsonProperty("product") Product product,
            @JsonProperty("user_id") User user) {
        this.rate = rate;
        this.comment = comment;
        this.product = product;
        this.user = user;
    }
}
