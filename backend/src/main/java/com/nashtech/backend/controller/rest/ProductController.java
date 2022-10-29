package com.nashtech.backend.controller.rest;

import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER')")
    ProductResponseDto getProductById(@PathVariable("id") Integer id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/get/{name}")
    List<ProductResponseDto> getAllProductByCategoryName(@PathVariable("name") String name) {
        return this.productService.getAllProductByCategory(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDto createProduct(@Valid @RequestBody ProductUpdateDto dto) {
        return this.productService.createProduct(dto);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ProductResponseDto updateProduct(@PathVariable("id") Integer id, @RequestBody ProductUpdateDto dto) {
        return this.productService.updateProduct(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Integer id) {
        this.productService.deleteProduct(id);
    }


}
