package com.nashtech.backend.services;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    public ProductResponseDto getProductByIdDto(Integer id);

    public ProductResponseDto createProduct(ProductUpdateDto dto);

    public ProductResponseDto updateProduct(Integer id, ProductUpdateDto dto);

    public ProductResponseDto deleteProduct(Integer id);

}
