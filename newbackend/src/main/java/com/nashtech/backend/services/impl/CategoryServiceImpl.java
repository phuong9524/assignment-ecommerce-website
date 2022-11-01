package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.dto.request.CategoryRequestDto;
import com.nashtech.backend.dto.response.CategoryResponseDto;
import com.nashtech.backend.exceptions.ProductCategoryNotFoundException;
import com.nashtech.backend.mappers.CategoryMapper;
import com.nashtech.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CategoryResponseDto> getAllCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return categoryMapper.mapListEntityToListDto(productCategories);
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        ProductCategory productCategory = categoryMapper.mapDtoToEntity(categoryRequestDto);
        ProductCategory saveProductCategory = productCategoryRepository.save(productCategory);
        return categoryMapper.mapEntityToDto(saveProductCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(Integer id, CategoryRequestDto categoryRequestDto) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
        if (productCategoryOptional.isEmpty()) {
            throw new ProductCategoryNotFoundException();
        }
        ProductCategory productCategory = productCategoryOptional.get();
        categoryMapper.mapDtoToEntity(categoryRequestDto);
        productCategory = productCategoryRepository.save(productCategory);
        return categoryMapper.mapEntityToDto(productCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
        if (productCategoryOptional.isPresent()) {
            productCategoryRepository.deleteById(id);
        }
        throw new ProductCategoryNotFoundException();
    }
}

