package com.nashtech.backend.services;

import com.nashtech.backend.dto.request.ProductRatingDto;
import com.nashtech.backend.dto.response.RatingResponseDto;

import java.util.Optional;

public interface RatingService {

    RatingResponseDto addRating(ProductRatingDto productRatingDto);

}
