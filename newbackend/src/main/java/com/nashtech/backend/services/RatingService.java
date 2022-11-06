package com.nashtech.backend.services;

import com.nashtech.backend.dto.rating.ProductRatingRequestDto;
import org.springframework.http.ResponseEntity;

public interface RatingService {

    ResponseEntity<?> addRating(ProductRatingRequestDto productRatingDto);

}

