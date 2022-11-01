package com.nashtech.backend.services;

import com.nashtech.backend.dto.request.ProductRatingDto;
import com.nashtech.backend.dto.response.RatingResponseDto;

public interface RatingService {

    RatingResponseDto addRating(ProductRatingDto productRatingDto);

}

