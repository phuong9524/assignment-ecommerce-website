package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.exceptions.ProductNotFoundException;
import com.nashtech.backend.mappers.ProductMapper;
import com.nashtech.backend.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public ProductResponseDto getProductById(Integer id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return productMapper.mapEntityToDto(product);
        }
        throw new ProductNotFoundException();
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
    public ProductResponseDto deleteProduct(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            this.productRepository.deleteById(id);
        }
        throw new ProductNotFoundException();

    }
}
