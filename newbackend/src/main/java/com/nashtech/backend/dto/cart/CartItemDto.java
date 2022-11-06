package com.nashtech.backend.dto.cart;

import com.nashtech.backend.data.entities.Product;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class CartItemDto {

    final Integer id;

    final @NotNull Integer quantity;

    final @NotNull Product product;

}
