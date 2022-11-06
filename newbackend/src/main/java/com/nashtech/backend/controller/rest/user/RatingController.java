package com.nashtech.backend.controller.rest.user;

import com.nashtech.backend.dto.rating.ProductRatingRequestDto;
import com.nashtech.backend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> ratingProduct(@Valid @RequestBody ProductRatingRequestDto dto) {
        return this.ratingService.addRating(dto);
    }
}

