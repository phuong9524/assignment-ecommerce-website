package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Cart;
import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.data.repositories.CartRepository;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.data.repositories.UserRepository;
import com.nashtech.backend.dto.cart.AddToCartDto;
import com.nashtech.backend.dto.cart.CartDto;
import com.nashtech.backend.dto.cart.CartItemDto;
import com.nashtech.backend.dto.auth.JwtResponseDto;
import com.nashtech.backend.exceptions.CartItemNotExistException;
import com.nashtech.backend.exceptions.CartNotFoundException;
import com.nashtech.backend.exceptions.UsernameNotFoundException;
import com.nashtech.backend.mappers.CartMapper;
import com.nashtech.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, CartMapper cartMapper, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<?> addToCart(AddToCartDto addToCartDto, JwtResponseDto jwtResponseDto) {
        String username = jwtResponseDto.getUsername();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("cant find username");
        }
        User user = userOptional.get();
        Product product = productRepository.findProductById(addToCartDto.getProductId());
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartRepository.save(cart);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CartDto> listCartItems(JwtResponseDto jwtResponseDto) {
        String username = jwtResponseDto.getUsername();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("cant find username");
        }
        User user = userOptional.get();
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreationDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList) {
            CartItemDto cartItemDto = cartMapper.mapCartToCartItemDto(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto: cartItems) {
            totalCost += (cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity());
        }
        CartDto cartDto = CartDto.builder()
                .cartItems(cartItems)
                .totalCost(totalCost).build();
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateCartItem(AddToCartDto addToCartDto) {

        Optional<Cart> cartOptional = cartRepository.findById(addToCartDto.getId());
        if (cartOptional.isEmpty()) {
            throw new CartNotFoundException();
        }
        Cart cart = cartOptional.get();
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreationDate(new Date());
        cartRepository.save(cart);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> deleteCartItem(int id) throws CartItemNotExistException {
        if (!cartRepository.existsById(id))
            throw new CartItemNotExistException("Cart id is invalid : " + id);
        cartRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
