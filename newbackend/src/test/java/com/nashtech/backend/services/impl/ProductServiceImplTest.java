package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.mappers.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    ProductRepository productRepository;
    ProductServiceImpl productServiceImpl;
    ProductResponseDto initialProductResponseDto;
    ProductCategoryRepository productCategoryRepository;
    ProductMapper productMapper;



    @BeforeEach
    public void setup() {
        initialProductResponseDto = ProductResponseDto.builder()
                .id(1)
                .name("X_PLR Shoes")
                .desc("Youth Originals")
                .image("https://picsum.photos/200/300")
                .price(1.500000)
                .build();

        productMapper = mock(ProductMapper.class);
        productRepository = mock(ProductRepository.class);
        productCategoryRepository = mock(ProductCategoryRepository.class);
        productServiceImpl = new ProductServiceImpl(productRepository, productCategoryRepository,productMapper);

    }

    @Test
    public void findById_shouldReturnProduct_whenDataValid() {
        Product expectedProduct = mock(Product.class);
        ProductResponseDto productResponseDto = mock(ProductResponseDto.class);

        when(productRepository.findById(1)).thenReturn(Optional.of(expectedProduct));
        when(productMapper.mapEntityToDto(expectedProduct)).thenReturn(productResponseDto);

        ProductResponseDto actual = productServiceImpl.getProductById(1);

        assertThat(actual, is(productResponseDto));

    }
}
