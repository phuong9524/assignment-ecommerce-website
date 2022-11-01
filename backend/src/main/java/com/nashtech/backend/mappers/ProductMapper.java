package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductResponseDto mapEntityToDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .image(product.getImage())
                .creationDate(product.getCreationDate().toString())
                .lastModifiedDate(product.getModifiedDate().toString())
                .build();
    }

    public List<ProductResponseDto> mapListEntityToListDto(List<Product> product) {
        return product.stream()
                .map(product1 -> new ProductResponseDto(
                        product1.getId(),
                        product1.getName(),
                        product1.getDesc(),
                        product1.getPrice(),
                        product1.getImage(),
                        product1.getCreationDate().toString(),
                        product1.getModifiedDate().toString()))
                .collect(Collectors.toList());
    }

    public Product mapDtoToEntity(ProductUpdateDto productUpdateDto) {
        return Product.builder()
                .name(productUpdateDto.getName())
                .desc(productUpdateDto.getDesc())
                .price(productUpdateDto.getPrice())
                .image(productUpdateDto.getImage())
                .build();
    }
}
