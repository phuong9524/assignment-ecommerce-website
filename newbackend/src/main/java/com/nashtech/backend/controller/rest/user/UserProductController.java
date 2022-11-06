package com.nashtech.backend.controller.rest.user;

import com.nashtech.backend.dto.product.ProductRequestDto;
import com.nashtech.backend.dto.product.GetProductByIdDto;
import com.nashtech.backend.dto.product.ShowAllProductForUserDto;
import com.nashtech.backend.dto.product.ShowLatestProductsDto;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/products")
@RestController
public class UserProductController {

    private final ProductService productService;

    @Autowired
    public UserProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    GetProductByIdDto getProductById(@PathVariable("id") Integer id) {
       return productService.getProductById(id);
    }

    @GetMapping("/get")
    List<ShowAllProductForUserDto> getAllProduct(@RequestParam int pageNumber) {
        return this.productService.getAllProduct(pageNumber);
    }

    @GetMapping("/latest")
    List<ShowLatestProductsDto> getLatestProduct() {
        return productService.showLatestProducts();
    }

    @PostMapping
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequestDto dto) {
        return productService.createProduct(dto);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductRequestDto dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Integer id) {
        this.productService.deleteProduct(id);
    }


}
