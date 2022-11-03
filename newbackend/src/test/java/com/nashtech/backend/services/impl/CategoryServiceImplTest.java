package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.dto.request.CategoryRequestDto;
import com.nashtech.backend.dto.response.CategoryResponseDto;
import com.nashtech.backend.exceptions.ProductCategoryNotFoundException;
import com.nashtech.backend.mappers.CategoryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;

public class CategoryServiceImplTest {

    ProductCategoryRepository productCategoryRepository;
    CategoryMapper categoryMapper;
    CategoryRequestDto categoryRequestDto;
    CategoryResponseDto categoryResponseDto;
    ProductCategory expectedCategory;
    CategoryServiceImpl categoryServiceImpl;

    @BeforeEach
    void setup() {
        productCategoryRepository = mock(ProductCategoryRepository.class);
        categoryMapper = mock(CategoryMapper.class);
        categoryRequestDto = mock(CategoryRequestDto.class);
        categoryResponseDto = mock(CategoryResponseDto.class);
        expectedCategory = mock(ProductCategory.class);
        categoryServiceImpl = new CategoryServiceImpl(productCategoryRepository, categoryMapper);
    }

    @Test
    void getAllCategory_shouldReturnListOfCategory() {
        when(productCategoryRepository.findAll()).thenReturn(List.of(expectedCategory));
        when(categoryMapper.mapListEntityToListDto(List.of(expectedCategory))).thenReturn(List.of(categoryResponseDto));

        List<CategoryResponseDto> result = categoryServiceImpl.getAllCategory();

        assertThat(result, is(List.of(categoryResponseDto)));
    }

    @Test
    void createCategory_shouldReturnCategoryResponseDto() {
        when(categoryMapper.mapDtoToEntity(categoryRequestDto)).thenReturn(expectedCategory);
        when(productCategoryRepository.save(expectedCategory)).thenReturn(expectedCategory);
        when(categoryMapper.mapEntityToDto(expectedCategory)).thenReturn(categoryResponseDto);

        CategoryResponseDto result = categoryServiceImpl.createCategory(categoryRequestDto);

        assertThat(result, is(categoryResponseDto));
    }

    @Test
    void updateCategory_shouldReturnCategoryResponseDto_whenDataValid() {
        when(productCategoryRepository.findById(1)).thenReturn(Optional.of(expectedCategory));
        when(categoryMapper.mapDtoToEntity(categoryRequestDto)).thenReturn(expectedCategory);
        when(productCategoryRepository.save(expectedCategory)).thenReturn(expectedCategory);
        when(categoryMapper.mapEntityToDto(expectedCategory)).thenReturn(categoryResponseDto);

        CategoryResponseDto result = categoryServiceImpl.updateCategory(1, categoryRequestDto);

        assertThat(result, is(categoryResponseDto));
    }

    @Test
    void updateCategory_shouldReturnProductCategoryNotFoundException_whenDataEmpty() {
        when(productCategoryRepository.findById(1)).thenReturn(Optional.empty());

        ProductCategoryNotFoundException result = Assertions.assertThrows(ProductCategoryNotFoundException.class,
                () -> categoryServiceImpl.updateCategory(1, categoryRequestDto));

        assertThat("Product category not found", is(result.getMessage()));
    }

}
