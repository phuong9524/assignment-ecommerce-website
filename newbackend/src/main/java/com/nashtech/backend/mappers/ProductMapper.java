package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.dto.product.ProductRequestDto;
import com.nashtech.backend.dto.product.GetProductByIdDto;
import com.nashtech.backend.dto.product.ShowAllProductForUserDto;
import com.nashtech.backend.dto.product.ShowLatestProductsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMapper {

    public List<ShowAllProductForUserDto> mapEntityToAllProductForUserDto(List<Product> product) {
        return product.stream()
                .map(productObject -> ShowAllProductForUserDto.builder()
                .id(productObject.getId())
                .name(productObject.getName())
                .desc(productObject.getDescription())
                .price(productObject.getPrice())
                .image(productObject.getImage())
                .categoryName(productObject.getProductCategory().getCategoryName())
                .build())
        .collect(Collectors.toList());

    }

    public GetProductByIdDto mapEntityToProductDto(Product product, Double avgRate) {
        return GetProductByIdDto.builder()
                .id(product.getId())
                .name(product.getName())
                .desc(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .categoryDesc(product.getProductCategory().getCategoryDesc())
                .avgRate(avgRate)
                .build();
    }

    public List<ShowLatestProductsDto> mapEntityToLatestProductDto(List<Product> product) {
        return product.stream()
                .map(product1 -> ShowLatestProductsDto.builder()
                                .id(product1.getId())
                                .name(product1.getName())
                                .desc(product1.getDescription())
                                .price(product1.getPrice())
                                .image(product1.getImage())
                                .creationDate(product1.getCreationDate())
                                .build())
                .collect(Collectors.toList());
    }

    public Product mapDtoToEntity(ProductRequestDto productUpdateDto, ProductCategory productCategory) {
        return Product.builder()
                .name(productUpdateDto.getName())
                .description(productUpdateDto.getDesc())
                .price(productUpdateDto.getPrice())
                .image(productUpdateDto.getImage())
                .productCategory(productCategory)
                .build();
    }
}
