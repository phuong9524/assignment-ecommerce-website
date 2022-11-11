package com.nashtech.backend.controller.rest.admin;

import com.nashtech.backend.dto.product.ProductRequestDto;
import com.nashtech.backend.dto.product.ShowAllProductForAdminDto;
import com.nashtech.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/product")
public class ManageProductController {

    final ProductService productService;

    @Autowired
    public ManageProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<ShowAllProductForAdminDto> GetAllProduct(@RequestParam int pageNumber) {
        return productService.getAllProductForAdmin(pageNumber);
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
