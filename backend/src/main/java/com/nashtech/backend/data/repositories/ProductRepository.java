package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT(p.*) from product p, product_category c where p.category_id = c.id and c.name = ?1",
            nativeQuery = true)
    List<Product> ShowAllProductByCategory(String name);

    Product findProductById(int id);

}
