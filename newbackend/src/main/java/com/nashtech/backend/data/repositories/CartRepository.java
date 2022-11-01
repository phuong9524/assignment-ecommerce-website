package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Cart;
import com.nashtech.backend.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreationDateDesc(User user);

    List<Cart> deleteByUser(User user);
}
