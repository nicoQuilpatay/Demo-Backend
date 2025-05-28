package com.ucc.Demo.Backend.service;

import com.ucc.Demo.Backend.Model.dto.ProductInfoDTO;
import com.ucc.Demo.Backend.Model.entities.Product;
import com.ucc.Demo.Backend.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    //Este Public no lo tiene Axel

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
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

    public List<ProductInfoDTO> getAllInfoProducts() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> new ProductInfoDTO(productEntity.getId(), productEntity.getName()))
                .collect(Collectors.toList());

    }
}
