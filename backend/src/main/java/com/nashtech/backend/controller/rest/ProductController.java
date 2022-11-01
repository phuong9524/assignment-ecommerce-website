package com.nashtech.backend.controller.rest;

import com.nashtech.backend.data.entities.Product;
import com.nashtech.backend.data.repositories.ProductRepository;
import com.nashtech.backend.dto.request.ProductUpdateDto;
import com.nashtech.backend.dto.response.ProductResponseDto;
import com.nashtech.backend.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/api/products")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/get/{id}")
    Product getProductById(@PathVariable("id") Integer id) {
//        return productService.getProductBy    Id(id);
        return repository.findProductById(id);
    }

    @GetMapping("/get/all")
    void getAll(){
        logger.info("Run controller find all");
        System.out.print("Run controller find all");
//        return repository.findAll();
    }

    @GetMapping("/get/{name}")
    List<ProductResponseDto> getAllProductByCategoryName(@PathVariable("name") String name) {
        return this.productService.getAllProductByCategory(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDto createProduct(@Valid @RequestBody ProductUpdateDto dto) {
        return productService.createProduct(dto);
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
