package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.dto.request.ProductRatingDto;
import com.nashtech.backend.dto.response.RatingResponseDto;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingResponseDto mapEntityToDto(Rating rating) {
        return RatingResponseDto.builder()
                .rate(rating.getRate())
                .comment(rating.getComment())
                .product(rating.getProduct())
                .user(rating.getUser())
                .build();
    }

    public Rating mapDtoToEntity(ProductRatingDto productRatingDto) {
        return Rating.builder()
                .rate(productRatingDto.getRate())
                .comment(productRatingDto.getComment())
                .product(productRatingDto.getProduct())
                .user(productRatingDto.getUser())
                .build();
    }
}

