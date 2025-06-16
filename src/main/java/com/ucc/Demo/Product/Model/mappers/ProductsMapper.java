package com.ucc.Demo.Product.Model.mappers;

import com.ucc.Demo.Product.Model.dto.ProductDTO;
import com.ucc.Demo.Product.Model.entities.Category;
import com.ucc.Demo.Product.Model.entities.Product;
import com.ucc.Demo.Product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductsMapper {

    private final CategoryRepository categoryRepository;

    public Product productsDTOToProductsEntity(ProductDTO productDTO){
        Product productEntity = new Product();
        productEntity.setName(productDTO.getName());
        productEntity.setStock(productDTO.getStock());
        productEntity.setDescription("creado por mapper");

        Category categoryEntity = categoryRepository.findOneById(productDTO.getCategoryDTO().getId());
        productEntity.setCategory(categoryEntity);
        return productEntity;
    }

    public ProductDTO ProductsEntityToProductInfoDTO(Product productEntity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(productEntity.getName());
        return  productDTO;
    }
}
