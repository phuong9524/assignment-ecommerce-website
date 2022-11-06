package com.nashtech.backend.services;

import com.nashtech.backend.dto.cart.AddToCartDto;
import com.nashtech.backend.dto.auth.JwtResponseDto;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addToCart(AddToCartDto addToCartDto, JwtResponseDto jwtResponseDto);

    ResponseEntity<?> listCartItems(JwtResponseDto jwtResponseDto);

    ResponseEntity<?> updateCartItem(AddToCartDto cartDto);

    ResponseEntity<?> deleteCartItem(int id);

}
