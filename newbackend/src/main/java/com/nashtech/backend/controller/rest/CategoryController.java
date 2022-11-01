package com.nashtech.backend.controller.rest;

import com.nashtech.backend.dto.request.CategoryRequestDto;
import com.nashtech.backend.dto.response.CategoryResponseDto;
import com.nashtech.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    List<CategoryResponseDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @PutMapping("/{id}")
    CategoryResponseDto updateCategory(@PathVariable("id") Integer id,@RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.updateCategory(id, categoryRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
    }

}

