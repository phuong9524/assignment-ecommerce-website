package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    @Query(value = "select(p.*) from product_category p where p.category_name = ?1", nativeQuery = true)
    List<ProductCategory> findByName(String name);

}
