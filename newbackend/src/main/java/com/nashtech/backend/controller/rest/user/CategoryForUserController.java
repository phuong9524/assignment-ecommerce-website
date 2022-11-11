package com.nashtech.backend.controller.rest.user;

import com.nashtech.backend.dto.category.ListCategoryNameDto;
import com.nashtech.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/category")
public class CategoryForUserController {

    CategoryService categoryService;

    @Autowired
    public CategoryForUserController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<ListCategoryNameDto> getListOfCategoryName() {
        return categoryService.getListOfCategoryName();
    }

}
