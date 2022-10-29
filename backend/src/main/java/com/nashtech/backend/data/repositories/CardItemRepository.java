package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardItemRepository extends JpaRepository<CartItem, Integer> {
}
