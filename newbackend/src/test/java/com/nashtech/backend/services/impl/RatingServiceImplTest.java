package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.repositories.RatingRepository;
import com.nashtech.backend.dto.request.ProductRatingDto;
import com.nashtech.backend.dto.response.RatingResponseDto;
import com.nashtech.backend.mappers.RatingMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;

public class RatingServiceImplTest {

    RatingRepository ratingRepository;
    RatingMapper ratingMapper;
    RatingServiceImpl ratingServiceImpl;
    ProductRatingDto productRatingDto;
    RatingResponseDto ratingResponseDto;
    Rating expectedRating;

    @BeforeEach
    void setup() {
        ratingRepository = mock(RatingRepository.class);
        ratingMapper = mock(RatingMapper.class);
        productRatingDto = mock(ProductRatingDto.class);
        ratingResponseDto = mock(RatingResponseDto.class);
        expectedRating = mock(Rating.class);
        ratingServiceImpl = new RatingServiceImpl(ratingRepository, ratingMapper);
    }

    @Test
    void addRating_shouldReturnRatingResponseDto() {
        when(ratingMapper.mapDtoToEntity(productRatingDto)).thenReturn(expectedRating);
        when(ratingRepository.save(expectedRating)).thenReturn(expectedRating);
        when(ratingMapper.mapEntityToDto(expectedRating)).thenReturn(ratingResponseDto);

        RatingResponseDto result = ratingServiceImpl.addRating(productRatingDto);

        assertThat(result, is(ratingResponseDto));
    }
}
