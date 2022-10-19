package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Integer> {
}
