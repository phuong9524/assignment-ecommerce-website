package com.nashtech.backend.dto.cart;

import lombok.*;


import java.util.List;


@Getter
@Builder
public class CartDto {

    final List<CartItemDto> cartItems;

    final double totalCost;

}
