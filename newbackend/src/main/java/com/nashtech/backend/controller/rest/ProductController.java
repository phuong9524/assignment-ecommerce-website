package com.nashtech.backend.controller.rest;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    ProductResponseDto getProductById(@PathVariable("id") Integer id) {
       return productService.getProductById(id);
    }

    @GetMapping("/get")
    List<ProductResponseDto> getAllProductByCategoryName(@RequestParam String name, @RequestParam int pageNumber,@RequestParam int pageSize) {
        return this.productService.getAllProductByCategory(name, pageNumber, pageSize);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDto createProduct(@Valid @RequestBody ProductUpdateDto dto) {
        return productService.createProduct(dto);
    }

    @PutMapping("/update/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") Integer id, @RequestBody ProductUpdateDto dto) {
        return this.productService.updateProduct(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Integer id) {
        this.productService.deleteProduct(id);
    }


}
