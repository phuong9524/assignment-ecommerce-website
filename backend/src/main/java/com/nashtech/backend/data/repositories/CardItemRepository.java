package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardItemRepository extends JpaRepository<CartItem, Integer> {
}
