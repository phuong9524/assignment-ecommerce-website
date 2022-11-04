package com.nashtech.backend.services;

import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProductById(Integer id);

    List<ProductResponseDto> getAllProductByCategory(String name, int pageNumber, int pageSize);

    ProductResponseDto createProduct(ProductUpdateDto dto);

    ProductResponseDto updateProduct(Integer id, ProductUpdateDto dto);

    void deleteProduct(Integer id);

}
