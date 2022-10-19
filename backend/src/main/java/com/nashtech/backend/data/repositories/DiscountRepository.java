package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
