package com.ucc.Demo.Product.service;

import com.ucc.Demo.Product.Model.dto.ProductDTO;
import com.ucc.Demo.Product.Model.dto.ProductInfoDTO;
import com.ucc.Demo.Product.Model.entities.Product;
import com.ucc.Demo.Product.Model.mappers.ProductsMapper;
import com.ucc.Demo.Product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductsMapper productsMapper;

    public ProductService(ProductRepository productRepository, ProductsMapper productsMapper){
        this.productRepository = productRepository;
        this.productsMapper = productsMapper;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public ResponseEntity<Product> newProduct(Product product){
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // ACTIVIDADEs
    public ResponseEntity<Product> getProductById(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    public ResponseEntity<Product> deleteProduct(Long id){
        Product productDelete = productRepository.findById(id).orElse(null);
        if (productDelete == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    public ResponseEntity<Product> modifyProduct(Long id, Product product){
        Product modifiedProduct = productRepository.findById(id).orElse(null);

        if (modifiedProduct == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            modifiedProduct.setDescription(product.getDescription());
            modifiedProduct.setName(product.getName());
            modifiedProduct.setPrice(product.getPrice());
            modifiedProduct.setStatus(product.getStatus());
            modifiedProduct.setStock(product.getStock());

            productRepository.save(modifiedProduct);
            return new ResponseEntity<>(modifiedProduct, HttpStatus.OK);
        }
    };

    // implementacion de DTO, este DTo devuelve el nombre del producto y su id

    public List<ProductInfoDTO> getAllInfoProducts() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> new ProductInfoDTO(productEntity.getId(), productEntity.getName(), productEntity.getDescription(),productEntity.getCategory(),productEntity.getStock()))
                .collect(Collectors.toList());

    }

    //Crear Producto desde DTO
    public ResponseEntity<Object> newProductFromDTO(ProductDTO productDTO){
        Product productEntity = productsMapper.productsDTOToProductsEntity(productDTO);
        productRepository.save(productEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
