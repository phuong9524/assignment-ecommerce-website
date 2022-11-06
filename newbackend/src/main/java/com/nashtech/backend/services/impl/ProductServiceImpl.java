package com.nashtech.backend.services.impl;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.entities.ProductCategory;
import com.nashtech.backend.data.entities.Rating;
import com.nashtech.backend.data.repositories.ProductCategoryRepository;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.data.repositories.RatingRepository;
import com.nashtech.backend.dto.product.ProductRequestDto;
import com.nashtech.backend.dto.product.GetProductByIdDto;
import com.nashtech.backend.dto.product.ShowAllProductForUserDto;
import com.nashtech.backend.dto.product.ShowLatestProductsDto;
import com.nashtech.backend.dto.rating.ShortRatingInfoDto;
import com.nashtech.backend.exceptions.ProductNotFoundException;
import com.nashtech.backend.exceptions.RatingNotFoundException;
import com.nashtech.backend.mappers.ProductMapper;
import com.nashtech.backend.mappers.RatingMapper;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final RatingRepository ratingRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper productMapper;
    private final RatingMapper ratingMapper;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository,
            ProductCategoryRepository productCategoryRepository,
            ProductMapper productMapper,
            RatingRepository ratingRepository,
            RatingMapper ratingMapper) {

        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productMapper = productMapper;
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    @Override
    public GetProductByIdDto getProductById(Integer id) {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        Product product = productOptional.get();

        List<Rating> ratings = ratingRepository.getAllByProductId(id);
        if (ratings.isEmpty()) {
            throw new RatingNotFoundException("Rating not found");
        }
        List<ShortRatingInfoDto> listShortRatingInfoDto = new ArrayList<>();
        for (Rating rating:ratings) {
            ShortRatingInfoDto shortRatingInfoDto = ratingMapper.mapEntityToShortRatingDto(rating);
            listShortRatingInfoDto.add(shortRatingInfoDto);
        }

        Double avgRate = 0.0;
        int count = 0;

        for (ShortRatingInfoDto shortRatingInfoDto: listShortRatingInfoDto) {
            avgRate += (shortRatingInfoDto.getRate());
            count++;
        }
        avgRate = avgRate/count;

        return productMapper.mapEntityToProductDto(product, avgRate);
    }

    @Override
    public List<ShowLatestProductsDto> showLatestProducts() {
        List<Product> products = productRepository.showLatestProducts();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        return productMapper.mapEntityToLatestProductDto(products);
    }

    @Override
    public List<ShowAllProductForUserDto> getAllProduct(int pageNumber) {

        Pageable pageWithNumberAndSize = PageRequest.of(pageNumber, 16);
        Page<Product> productPage = productRepository.findAll(pageWithNumberAndSize);
        List<Product> products = productPage.getContent();
        return productMapper.mapEntityToAllProductForUserDto(products);
    }

    @Override
    public ResponseEntity<?> createProduct(ProductRequestDto dto) {

        ProductCategory productCategory = productCategoryRepository.getProductCategoryByCategoryName(dto.getCategoryName());
        Product product = productMapper.mapDtoToEntity(dto, productCategory);
        productRepository.save(product);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateProduct(Integer id, ProductRequestDto dto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product product = productOptional.get();
        ProductCategory productCategory = productCategoryRepository.getProductCategoryByCategoryName(dto.getCategoryName());
        productMapper.mapDtoToEntity(dto, productCategory);
        productRepository.save(product);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
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

