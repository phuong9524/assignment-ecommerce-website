package com.nashtech.backend.controller.rest;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("/get/{id}")
    ProductResponseDto getProductById(@PathVariable("id") Integer id) {
        return this.productService.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDto createProduct(@Valid @RequestBody ProductUpdateDto dto) {
        return this.productService.createProduct(dto);
    }

    @PutMapping("/update/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") Integer id, @RequestBody ProductUpdateDto dto) {
        return this.productService.updateProduct(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    ProductResponseDto deleteProduct(@PathVariable("id") Integer id) {
        return this.productService.deleteProduct(id);
    }


}
