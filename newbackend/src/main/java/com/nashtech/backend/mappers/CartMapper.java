package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Cart;
import com.nashtech.backend.dto.cart.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartItemDto mapCartToCartItemDto(Cart cart) {
        return CartItemDto.builder()
                .id(cart.getId())
                .quantity(cart.getQuantity())
                .product(cart.getProduct())
                .build();
    }
}
