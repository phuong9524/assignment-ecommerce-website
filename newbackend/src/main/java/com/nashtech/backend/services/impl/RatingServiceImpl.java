package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.data.repositories.RatingRepository;
import com.nashtech.backend.data.repositories.UserRepository;
import com.nashtech.backend.dto.rating.ProductRatingRequestDto;
import com.nashtech.backend.exceptions.ProductNotFoundException;
import com.nashtech.backend.mappers.RatingMapper;
import com.nashtech.backend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;
    RatingMapper ratingMapper;
    ProductRepository productRepository;
    UserRepository userRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository, RatingMapper ratingMapper, ProductRepository productRepository, UserRepository userRepository) {
        this.ratingMapper = ratingMapper;
        this.ratingRepository = ratingRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> addRating(ProductRatingRequestDto productRatingDto) {

        Optional<Product> productOptional = productRepository.findById(productRatingDto.getProductId());
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("product not found");
        }
        Product product = productOptional.get();

        Optional<User> userOptional = userRepository.findByUsername(productRatingDto.getUsername());
        if (userOptional.isEmpty()) {
            throw new ProductNotFoundException("product not found");
        }
        User user = userOptional.get();

        Rating rating = ratingMapper.mapDtoToEntity(productRatingDto, product, user);
        ratingRepository.save(rating);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
