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

@RequestMapping("/api/user/products")
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
        return this.productService.getAllProductForUser(pageNumber);
    }

    @GetMapping("/latest")
    List<ShowLatestProductsDto> getLatestProduct() {
        return productService.showLatestProducts();
    }


}
