package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.dto.category.CategoryForGetProductByIdDto;
import com.nashtech.backend.dto.category.FullCategoryInfoDto;
import com.nashtech.backend.dto.category.CategoryRequestDto;
import com.nashtech.backend.dto.category.ListCategoryNameDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryForGetProductByIdDto mapEntityToCategoryUserDto(ProductCategory productCategory) {
        return CategoryForGetProductByIdDto.builder()
                .categoryName(productCategory.getCategoryName())
                .categoryDesc(productCategory.getCategoryDesc())
                .build();
    }

    public List<FullCategoryInfoDto> mapEntityToCategoryAdminDto(List<ProductCategory> productCategory) {
        return productCategory.stream()
                .map(productCategoryObject -> FullCategoryInfoDto.builder()
                        .id(productCategoryObject.getId())
                        .categoryName(productCategoryObject.getCategoryName())
                        .categoryDesc(productCategoryObject.getCategoryDesc())
                        .creationDate(productCategoryObject.getCreationDate())
                        .lastModifiedDate(productCategoryObject.getModifiedDate())
                        .build())
                .collect(Collectors.toList());
    }

    public List<ListCategoryNameDto> mapEntityToListCategoryNameDto(List<ProductCategory> productCategories) {
        return productCategories.stream()
                .map(productCategory -> ListCategoryNameDto.builder()
                        .categoryName(productCategory.getCategoryName()).build())
                .collect(Collectors.toList());
    }

    public ProductCategory mapDtoToEntity(CategoryRequestDto categoryRequestDto) {
        return ProductCategory.builder()
                .categoryName(categoryRequestDto.getCategoryName())
                .categoryDesc(categoryRequestDto.getCategoryDesc())
                .build();
    }
}

