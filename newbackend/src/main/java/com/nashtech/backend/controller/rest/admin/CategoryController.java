package com.nashtech.backend.controller.rest.admin;

import com.nashtech.backend.dto.category.FullCategoryInfoDto;
import com.nashtech.backend.dto.category.CategoryRequestDto;
import com.nashtech.backend.dto.category.ListCategoryNameDto;
import com.nashtech.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin")
    List<FullCategoryInfoDto> getAllCategoryForAdmin() {
        return categoryService.getAllCategoryForAdmin();
    }

    @GetMapping
    List<ListCategoryNameDto> getListOfCategoryName() {
        return categoryService.getListOfCategoryName();
    }

    @PostMapping
    ResponseEntity<?> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.updateCategory(id, categoryRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
    }

}

