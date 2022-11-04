package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMapper {

    public ProductResponseDto mapEntityToDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .desc(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .productCategory(product.getProductCategory())
                .creationDate(product.getCreationDate().toString())
                .lastModifiedDate(product.getModifiedDate().toString())
                .build();
    }

    public List<ProductResponseDto> mapListEntityToListDto(List<Product> product) {
        return product.stream()
                .map(product1 -> new ProductResponseDto(
                        product1.getId(),
                        product1.getName(),
                        product1.getDescription(),
                        product1.getPrice(),
                        product1.getImage(),
                        product1.getProductCategory(),
                        product1.getCreationDate().toString(),
                        product1.getModifiedDate().toString()))
                .collect(Collectors.toList());
    }

    public Product mapDtoToEntity(ProductUpdateDto productUpdateDto, ProductCategory productCategory) {
        return Product.builder()
                .name(productUpdateDto.getName())
                .description(productUpdateDto.getDesc())
                .price(productUpdateDto.getPrice())
                .image(productUpdateDto.getImage())
                .productCategory(productCategory)
                .build();
    }
}
