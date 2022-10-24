package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
