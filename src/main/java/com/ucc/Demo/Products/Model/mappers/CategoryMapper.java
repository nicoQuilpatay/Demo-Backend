package com.ucc.Demo.Products.Model.mappers;

import com.ucc.Demo.Products.Model.dto.CategoryDTO;
import com.ucc.Demo.Products.Model.dto.ProductInfoDTO;
import com.ucc.Demo.Products.Model.entities.Category;
import com.ucc.Demo.Products.Model.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category CategoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
        Category CategoryEntity = new Category();
        CategoryEntity.setId(categoryDTO.getId());
        return CategoryEntity;
    }

    public CategoryDTO CategoryEntityToCategoryDTO(Category categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        return  categoryDTO;
    }
}
