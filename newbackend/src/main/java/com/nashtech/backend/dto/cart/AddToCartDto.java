package com.nashtech.backend.dto.cart;

import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Builder
public class AddToCartDto {

    final Integer id;

    final @NotNull Integer productId;

    final @NotNull Integer quantity;


}
