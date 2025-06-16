package com.ucc.Demo.Products.service;

import com.ucc.Demo.Products.Model.dto.CategoryDTO;
import com.ucc.Demo.Products.Model.dto.ProductInfoDTO;
import com.ucc.Demo.Products.Model.entities.Category;
import com.ucc.Demo.Products.Model.entities.Product;
import com.ucc.Demo.Products.Model.mappers.CategoryMapper;
import com.ucc.Demo.Products.Model.mappers.ProductsMapper;
import com.ucc.Demo.Products.repository.CategoryRepository;
import com.ucc.Demo.Products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
