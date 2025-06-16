package com.ucc.Demo.Product.service;

import com.ucc.Demo.Product.Model.entities.Category;
import com.ucc.Demo.Product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    //private final CategoryMapper categoryMapper;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<Object> newCategory(Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
