package com.ucc.Demo.Product.Model.mappers;

import com.ucc.Demo.Product.Model.dto.CategoryDTO;
import com.ucc.Demo.Product.Model.entities.Category;
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
