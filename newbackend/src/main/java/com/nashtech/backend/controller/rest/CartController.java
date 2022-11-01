package com.nashtech.backend.controller.rest;

import com.nashtech.backend.dto.request.AddToCartDto;
import com.nashtech.backend.dto.response.JwtResponseDto;
import com.nashtech.backend.services.CartService;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;


    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/")
   public ResponseEntity<?> addToCart(@RequestBody AddToCartDto addToCartDto, JwtResponseDto jwtResponseDto) {
        return cartService.addToCart(addToCartDto, jwtResponseDto);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCardItems(JwtResponseDto jwtResponseDto) {
        return cartService.listCartItems(jwtResponseDto);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<?> updateCartItem(@RequestBody @Valid AddToCartDto addToCartDto, JwtResponseDto jwtResponseDto, @PathVariable String cartItemId) {
        return cartService.updateCartItem(addToCartDto, jwtResponseDto);
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable("cartItemId") int itemId, JwtResponseDto jwtResponseDto) {
        return cartService.deleteCartItem(itemId, jwtResponseDto);
    }
}
