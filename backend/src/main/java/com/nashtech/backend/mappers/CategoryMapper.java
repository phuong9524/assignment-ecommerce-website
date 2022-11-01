package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.dto.request.CategoryRequestDto;
import com.nashtech.backend.dto.response.CategoryResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public CategoryResponseDto mapEntityToDto(ProductCategory productCategory) {
        return CategoryResponseDto.builder()
                .categoryName(productCategory.getCategoryName())
                .categoryDesc(productCategory.getCategoryDesc())
                .creationDate(productCategory.getCreationDate().toString())
                .lastModifiedDate(productCategory.getModifiedDate().toString())
                .build();
    }

    public List<CategoryResponseDto> mapListEntityToListDto(List<ProductCategory> productCategory) {
        return productCategory.stream()
                .map(productCategory1 -> new CategoryResponseDto(
                        productCategory1.getCategoryName(),
                        productCategory1.getCategoryDesc(),
                        productCategory1.getCreationDate().toString(),
                        productCategory1.getModifiedDate().toString()))
                .collect(Collectors.toList());
    }

    public ProductCategory mapDtoToEntity(CategoryRequestDto categoryRequestDto) {
        return ProductCategory.builder()
                .categoryName(categoryRequestDto.getCategoryName())
                .categoryDesc(categoryRequestDto.getCategoryDesc())
                .build();
    }
}
