package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    ProductCategory getProductCategoryByCategoryName(String name);

    @Query(value = "SELECT * FROM product_category", nativeQuery = true)
    List<ProductCategory> getAllCategoryName();

}
