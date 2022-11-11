package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.data.repositories.RatingRepository;
import com.nashtech.backend.data.repositories.UserRepository;
import com.nashtech.backend.dto.rating.FullRatingInfoDto;
import com.nashtech.backend.dto.rating.ProductRatingRequestDto;
import com.nashtech.backend.mappers.RatingMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;

public class RatingServiceImplTest {

    RatingRepository ratingRepository;
    RatingMapper ratingMapper;
    RatingServiceImpl ratingServiceImpl;
    ProductRatingRequestDto productRatingRequestDto;
    FullRatingInfoDto ratingResponseDto;
    Rating RatingObject;
    Product productObject;
    User userObject;
    ProductRepository productRepository;
    ProductRatingRequestDto expectedRating;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        ratingServiceImpl = new RatingServiceImpl(ratingRepository, ratingMapper, productRepository, userRepository);
    }

    @Test
    void addRating_shouldReturnRatingResponseDto() {
        productRepository = mock(ProductRepository.class);
        ratingRepository = mock(RatingRepository.class);
        userRepository = mock(UserRepository.class);
        ratingMapper = mock(RatingMapper.class);
        productObject = mock(Product.class);
        userObject = mock(User.class);
        RatingObject = mock(Rating.class);


        when(productRepository.findById(1)).thenReturn(Optional.of(productObject));
        when(userRepository.findByUsername("phuong")).thenReturn(Optional.of(userObject));
        when(ratingMapper.mapDtoToEntity(productRatingRequestDto, productObject, userObject)).thenReturn(RatingObject);
        when(ratingRepository.save(RatingObject)).thenReturn(RatingObject);


    }
}
