package com.ucc.Demo.Backend.Model.mappers;

import com.ucc.Demo.Backend.Model.dto.ProductInfoDTO;
import com.ucc.Demo.Backend.Model.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductsMapper {

    public Product productsInfoDTOToProductsEntity(ProductInfoDTO productDTO){
        Product productEntity = new Product();
        productEntity.setName(productDTO.getName());
        productEntity.setId(productDTO.getId());
        productEntity.setDescription("creado por mapper");
        return productEntity;
    }

    public ProductInfoDTO ProductsEntityToProductInfoDTO(Product productEntity){
        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
        productInfoDTO.setId(productEntity.getId());
        productInfoDTO.setName(productEntity.getName());
        productInfoDTO.setDescription("creado por mapper");
        return  productInfoDTO;
    }
}
