package com.nashtech.backend.services;

import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProductById(Integer id);

    List<ProductResponseDto> getAllProductByCategory(String name);

    ProductResponseDto createProduct(ProductUpdateDto dto);

    ProductResponseDto updateProduct(Integer id, ProductUpdateDto dto);

    void deleteProduct(Integer id);

}
