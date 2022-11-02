package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.exceptions.ProductCategoryNotFoundException;
import com.nashtech.backend.exceptions.ProductNotFoundException;
import com.nashtech.backend.mappers.ProductMapper;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository,
            ProductCategoryRepository productCategoryRepository,
            ProductMapper productMapper) {

        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDto getProductById(Integer id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product product = productOptional.get();
        return productMapper.mapEntityToDto(product);
    }

    @Override
    public List<ProductResponseDto> getAllProductByCategory(String categoryName) {
        List<ProductCategory> productCategoryOptional = this.productCategoryRepository.findByName(categoryName);
        if (productCategoryOptional.isEmpty()) {
            throw new ProductCategoryNotFoundException();
        }
        List<Product> product = productRepository.ShowAllProductByCategory(categoryName);
        return productMapper.mapListEntityToListDto(product);
    }

    @Override
    public ProductResponseDto createProduct(ProductUpdateDto dto) {
        Product product = productMapper.mapDtoToEntity(dto);
        Product saveProduct = productRepository.save(product);
        return productMapper.mapEntityToDto(saveProduct);
    }

    @Override
    public ProductResponseDto updateProduct(Integer id, ProductUpdateDto dto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product product = productOptional.get();
        productMapper.mapDtoToEntity(dto);
        product = productRepository.save(product);
        return productMapper.mapEntityToDto(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        this.productRepository.deleteById(id);


    }
}

