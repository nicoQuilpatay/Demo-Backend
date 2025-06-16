package com.ucc.Demo.Product.webRest;


import com.ucc.Demo.Product.Model.entities.Category;
import com.ucc.Demo.Product.service.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping

public class CategoryController {

    private  final CategoryService categoryService;

    @GetMapping("/api/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/api/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> newCategories(@RequestBody Category category) {
        return categoryService.newCategory(category);
    }




}
