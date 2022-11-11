package com.nashtech.backend.services;

import com.nashtech.backend.dto.product.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    GetProductByIdDto getProductById(Integer id);

    List<ShowLatestProductsDto> showLatestProducts();

    List<ShowAllProductForUserDto> getAllProductForUser(int pageNumber);

    List<ShowAllProductForAdminDto> getAllProductForAdmin(int pageNumber);

    ResponseEntity<?> createProduct(ProductRequestDto dto);

    ResponseEntity<?> updateProduct(Integer id, ProductRequestDto dto);

    void deleteProduct(Integer id);

}
