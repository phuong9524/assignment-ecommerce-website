package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDto mapEntityToDto(Product product) {
        return ProductResponseDto.builder()
                .name(product.getName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .creationDate(product.getCreationDate().toString())
                .lastModifiedDate(product.getModifiedDate().toString())
                .build();
    }

    public Product mapDtoToEntity(ProductUpdateDto productUpdateDto) {
        return Product.builder()
                .name(productUpdateDto.getName())
                .desc(productUpdateDto.getDesc())
                .price(productUpdateDto.getPrice())
                .build();
    }
}
