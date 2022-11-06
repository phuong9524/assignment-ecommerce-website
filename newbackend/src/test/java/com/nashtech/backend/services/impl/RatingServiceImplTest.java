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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;

public class RatingServiceImplTest {

    RatingRepository ratingRepository;
    RatingMapper ratingMapper;
    RatingServiceImpl ratingServiceImpl;
    ProductRatingRequestDto productRatingDto;
    FullRatingInfoDto ratingResponseDto;
    FullRatingInfoDto fullRatingInfoDto;
    Rating expectedRating;
    Product product;
    User user;
    ProductRepository productRepository;
    ProductRatingRequestDto expectedProduct;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        ratingRepository = mock(RatingRepository.class);
        ratingMapper = mock(RatingMapper.class);
        productRatingDto = mock(ProductRatingRequestDto.class);
        ratingResponseDto = mock(FullRatingInfoDto.class);
        productRepository = mock(ProductRepository.class);
        userRepository = mock(UserRepository.class);
        expectedRating = mock(Rating.class);
        ratingServiceImpl = new RatingServiceImpl(ratingRepository, ratingMapper, productRepository, userRepository);
    }

//    @Test
//    void addRating_shouldReturnRatingResponseDto() {
//        fullRatingInfoDto = mock(FullRatingInfoDto.class);
//
//        product = mock(Product.class);
//        user = mock(User.class);
//
//        expectedProduct = ProductRatingDto.builder()
//                .productId(1)
//                .rate(2.4)
//                .comment("test")
//                .username("phuong").build();
//
//
//        when(productRepository.findById(1)).thenReturn(Optional.of(product));
//        when(userRepository.findByUsername("phuong")).thenReturn(Optional.of(user));
//        when(ratingMapper.mapDtoToEntity(productRatingDto, product, user)).thenReturn(expectedRating);
//        when(ratingRepository.save(expectedRating)).thenReturn(expectedRating);
//        when(ratingMapper.mapEntityToDto(expectedRating)).thenReturn(ratingResponseDto);
//
//        FullRatingInfoDto result = ratingServiceImpl.addRating(productRatingDto);
//
//        assertThat(result, is(ratingResponseDto));
//    }
}
