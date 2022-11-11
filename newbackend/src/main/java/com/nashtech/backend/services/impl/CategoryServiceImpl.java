package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.dto.category.FullCategoryInfoDto;
import com.nashtech.backend.dto.category.CategoryRequestDto;
import com.nashtech.backend.dto.category.ListCategoryNameDto;
import com.nashtech.backend.exceptions.ProductCategoryNotFoundException;
import com.nashtech.backend.mappers.CategoryMapper;
import com.nashtech.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(ProductCategoryRepository productCategoryRepository, CategoryMapper categoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<FullCategoryInfoDto> getAllCategoryForAdmin() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return categoryMapper.mapEntityToCategoryAdminDto(productCategories);
    }

    @Override
    public List<ListCategoryNameDto> getListOfCategoryName() {
        List<ProductCategory> productCategory = productCategoryRepository.getAllCategoryName();
        if (productCategory.isEmpty()) {
            throw new ProductCategoryNotFoundException("Cant find category");
        }
        return categoryMapper.mapEntityToListCategoryNameDto(productCategory);
    }

    @Override
    public ResponseEntity<?> createCategory(CategoryRequestDto categoryRequestDto) {
        ProductCategory productCategory = categoryMapper.mapDtoToEntity(categoryRequestDto);
        ProductCategory saveProductCategory = productCategoryRepository.save(productCategory);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCategory(Integer id, CategoryRequestDto categoryRequestDto) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
        if (productCategoryOptional.isEmpty()) {
            throw new ProductCategoryNotFoundException("Product category not found");
        }
        ProductCategory productCategory = productCategoryOptional.get();
        categoryMapper.mapDtoToEntity(categoryRequestDto);
        productCategoryRepository.save(productCategory);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> deleteCategory(Integer id) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
        if (productCategoryOptional.isPresent()) {
            productCategoryRepository.deleteById(id);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }
        throw new ProductCategoryNotFoundException();
    }
}

