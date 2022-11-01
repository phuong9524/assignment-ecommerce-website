package com.nashtech.backend.services;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.dto.request.AddToCartDto;
import com.nashtech.backend.dto.response.CartDto;
import com.nashtech.backend.dto.response.JwtResponseDto;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addToCart(AddToCartDto addToCartDto, JwtResponseDto jwtResponseDto);

    ResponseEntity<?> listCartItems(JwtResponseDto jwtResponseDto);

    ResponseEntity<?> updateCartItem(AddToCartDto cartDto, JwtResponseDto jwtResponseDto);

    ResponseEntity<?> deleteCartItem(int id, JwtResponseDto jwtResponseDto);

}
