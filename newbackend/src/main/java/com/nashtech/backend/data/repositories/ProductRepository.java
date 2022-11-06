package com.nashtech.backend.data.repositories;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.product.ShowLatestProductsDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT(p.*) from product p, product_category c where p.category_id = c.id and c.category_name = ?1",
            nativeQuery = true)
    List<Product> showAllProductByCategory(String name, Pageable pageable);

    Product findProductById(int id);

    @Query(value = "SELECT (product.*) from product order by product.created_at desc limit 8", nativeQuery = true)
    List<Product> showLatestProducts();

}
