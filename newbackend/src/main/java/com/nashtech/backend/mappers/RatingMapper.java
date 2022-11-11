package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.dto.rating.FullRatingInfoDto;
import com.nashtech.backend.dto.rating.ProductRatingRequestDto;
import com.nashtech.backend.dto.rating.ShortRatingInfoDto;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public FullRatingInfoDto mapEntityToDto(Rating rating) {
        return FullRatingInfoDto.builder()
                .rate(rating.getRate())
                .user(rating.getUser())
                .build();
    }

    public Rating mapDtoToEntity(ProductRatingRequestDto productRatingDto, Product product, User user) {
        return Rating.builder()
                .rate(productRatingDto.getRate())
                .product(product)
                .user(user)
                .build();
    }

    public ShortRatingInfoDto mapEntityToShortRatingDto(Rating rating) {
        return ShortRatingInfoDto.builder()
                .rate(rating.getRate()).build();
    }
}

