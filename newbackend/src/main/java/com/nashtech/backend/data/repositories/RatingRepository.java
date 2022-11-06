package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> getAllByProductId(Integer id);
}
