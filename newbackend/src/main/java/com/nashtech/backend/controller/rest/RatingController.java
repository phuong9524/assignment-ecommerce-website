package com.nashtech.backend.controller.rest;

import com.nashtech.backend.dto.request.ProductRatingDto;
import com.nashtech.backend.dto.response.RatingResponseDto;
import com.nashtech.backend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    RatingResponseDto ratingProduct(@Valid @RequestBody ProductRatingDto dto) {
        return this.ratingService.addRating(dto);
    }
}

