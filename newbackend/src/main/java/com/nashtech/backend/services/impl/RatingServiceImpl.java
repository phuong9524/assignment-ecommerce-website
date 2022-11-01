package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.repositories.RatingRepository;
import com.nashtech.backend.dto.request.ProductRatingDto;
import com.nashtech.backend.dto.response.RatingResponseDto;
import com.nashtech.backend.mappers.RatingMapper;
import com.nashtech.backend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;
    RatingMapper ratingMapper;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingMapper = ratingMapper;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingResponseDto addRating(ProductRatingDto productRatingDto) {
        Rating rating = ratingMapper.mapDtoToEntity(productRatingDto);
        Rating saveRating = ratingRepository.save(rating);
        return ratingMapper.mapEntityToDto(saveRating);
    }
}
