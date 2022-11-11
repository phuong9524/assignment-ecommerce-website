package com.nashtech.backend.services;

import com.nashtech.backend.dto.category.FullCategoryInfoDto;
import com.nashtech.backend.dto.category.CategoryRequestDto;
import com.nashtech.backend.dto.category.ListCategoryNameDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<FullCategoryInfoDto> getAllCategoryForAdmin();

    List<ListCategoryNameDto> getListOfCategoryName();

    ResponseEntity<?> createCategory(CategoryRequestDto categoryRequestDto);

    ResponseEntity<?> updateCategory(Integer id, CategoryRequestDto categoryRequestDto);

    ResponseEntity<?> deleteCategory(Integer id);
}

