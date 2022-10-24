package com.nashtech.backend.services;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProductById(Integer id);

    ProductResponseDto createProduct(ProductUpdateDto dto);

    ProductResponseDto updateProduct(Integer id, ProductUpdateDto dto);

    ProductResponseDto deleteProduct(Integer id);

}
