package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.data.repositories.RatingRepository;
import com.nashtech.backend.dto.product.ProductRequestDto;
import com.nashtech.backend.dto.product.GetProductByIdDto;
import com.nashtech.backend.dto.product.ShowLatestProductsDto;
import com.nashtech.backend.exceptions.ProductCategoryNotFoundException;
import com.nashtech.backend.exceptions.ProductNotFoundException;
import com.nashtech.backend.mappers.ProductMapper;
import com.nashtech.backend.mappers.RatingMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.mockito.MockedStatic;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    ProductRepository productRepository;
    ProductServiceImpl productServiceImpl;
    ProductCategoryRepository productCategoryRepository;
    ProductMapper productMapper;
    ProductRequestDto productUpdateDto;
    Product expectedProduct;
    GetProductByIdDto productResponseDto;
    Pageable pageable;
    MockedStatic<PageRequest> pageRequest;
    ProductCategory productCategory;
    ShowLatestProductsDto showProductForUserDto;
    RatingRepository ratingRepository;
    RatingMapper ratingMapper;

    @BeforeEach
    void setup() {

        productMapper = mock(ProductMapper.class);
        productRepository = mock(ProductRepository.class);
        productCategoryRepository = mock(ProductCategoryRepository.class);
        productUpdateDto = mock(ProductRequestDto.class);
        expectedProduct = mock(Product.class);
        productResponseDto = mock(GetProductByIdDto.class);
        pageable = mock(Pageable.class);
        pageRequest = mockStatic(PageRequest.class);
        productCategory = mock(ProductCategory.class);

        productServiceImpl = new ProductServiceImpl(productRepository,
                productCategoryRepository,
                productMapper,
                ratingRepository,
                ratingMapper);

    }

    @Test
    void findById_shouldReturnProduct_whenDataValid() {

//        showProductForUserDto = mock(ShowLatestProductsDto.class);
//
//        when(productRepository.findById(1)).thenReturn(Optional.of(expectedProduct));
//        when(ratingRepository.getAllByProductId(1)).thenReturn()
//        when(productMapper.mapEntityToDto(expectedProduct)).thenReturn(productResponseDto);
//
//        GetProductByIdDto result = productServiceImpl.getProductById(1);
//
//        assertThat(result, is(productResponseDto));
    }

    @Test
    void findById_shouldThrowProductNotFoundException_whenProductIsEmpty() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        ProductNotFoundException result = Assertions.assertThrows(ProductNotFoundException.class,
                () -> productServiceImpl.getProductById(1));

        assertThat("Product not found", is(result.getMessage()));
    }

//    @Test
//    void findByCategory_shouldReturnListOfProducts_whenDataValid() {
//        ProductCategory expectedProductCategory = mock(ProductCategory.class);
//
//        when(productCategoryRepository.findByName("name")).thenReturn(List.of(expectedProductCategory));
//        pageRequest.when(() -> PageRequest.of(1,1)).thenReturn(pageable);
//        when(productRepository.ShowAllProductByCategory("name", pageable)).thenReturn(List.of(expectedProduct));
//        when(productMapper.mapListEntityToListDto(List.of(expectedProduct))).thenReturn(List.of(productResponseDto));
//
//        List<ProductResponseDto> result = productServiceImpl.getAllProductByCategory("name", 1, 1);
//
//        assertThat(result, is(List.of(productResponseDto)));
//    }

    @Test
    void findByCategory_shouldThrowProductCategoryNotFoundException_whenProductCategoryIsEmpty() {
//        when(productCategoryRepository.findByName("name")).thenReturn(Collections.emptyList());
//
//        ProductCategoryNotFoundException result = Assertions.assertThrows(ProductCategoryNotFoundException.class,
//                () -> productServiceImpl.getAllProductByCategory("name", 1, 1));
//
//        assertThat("Product category not found", is(result.getMessage()));
    }

//    @Test
//    void createProduct_shouldReturnProductResponseDto() {
//        when(productCategoryRepository.findById(productUpdateDto.getCategoryId())).thenReturn(Optional.of(productCategory));
//        when(productMapper.mapDtoToEntity(productUpdateDto, productCategory)).thenReturn(expectedProduct);
//        when(productRepository.save(expectedProduct)).thenReturn(expectedProduct);
//        when(productMapper.mapEntityToDto(expectedProduct)).thenReturn(productResponseDto);
//
//        GetProductByIdDto result = productServiceImpl.createProduct(productUpdateDto);
//
//        assertThat(result, is(productResponseDto));
//    }

    @Test
    void updateProduct_shouldReturnProductResponseDto_whenDataValid() {
//        productUpdateDto = ProductUpdateDto.builder()
//                .name("pegasus")
//                .desc("shoes for men")
//                .price(1000.0)
//                .image("http")
//                .build();
//        when(productCategoryRepository.findById(productUpdateDto.getCategoryId())).thenReturn(Optional.of(productCategory));
//        when(productRepository.findById(1)).thenReturn(Optional.of(expectedProduct));
//        when(productMapper.mapDtoToEntity(productUpdateDto, productCategory)).thenReturn(expectedProduct);
//        when(productRepository.save(expectedProduct)).thenReturn(expectedProduct);
//        when(productMapper.mapEntityToDto(expectedProduct)).thenReturn(productResponseDto);

//        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
//        GetProductByIdDto result = productServiceImpl.updateProduct(1, productUpdateDto);
//        verify(productRepository).save(productCaptor.capture());
//        Product updateProduct = productCaptor.getValue();
//
//        assertThat(updateProduct.getName(), is("pegasus"));
//        assertThat(updateProduct.getPrice(), is(1000.0));
//        assertThat(updateProduct.getDescription(), is("shoes for men"));
//        assertThat(updateProduct.getImage(), is("http"));
//        assertThat(result, is(productResponseDto));

    }


}
