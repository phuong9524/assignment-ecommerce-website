package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
