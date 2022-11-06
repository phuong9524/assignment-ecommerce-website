package com.nashtech.backend.services;

import com.nashtech.backend.dto.product.ProductRequestDto;
import com.nashtech.backend.dto.product.GetProductByIdDto;
import com.nashtech.backend.dto.product.ShowAllProductForUserDto;
import com.nashtech.backend.dto.product.ShowLatestProductsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    GetProductByIdDto getProductById(Integer id);

    List<ShowLatestProductsDto> showLatestProducts();

    List<ShowAllProductForUserDto> getAllProduct(int pageNumber);

    ResponseEntity<?> createProduct(ProductRequestDto dto);

    ResponseEntity<?> updateProduct(Integer id, ProductRequestDto dto);

    void deleteProduct(Integer id);

}
