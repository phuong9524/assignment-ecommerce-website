package com.nashtech.backend.controller.rest;

import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("api/add/{id}")
    ProductResponseDto getProductByIdDto(@PathVariable("id") Integer id) {
        return this.productService.getProductByIdDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDto createProduct(@Valid @RequestBody ProductUpdateDto dto) {
        return this.productService.createProduct(dto);
    }

    @PutMapping("api/update/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") Integer id, @RequestBody ProductUpdateDto dto) {
        return this.productService.updateProduct(id, dto);
    }

}
