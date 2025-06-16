package com.ucc.Demo.Product.webRest;

import com.ucc.Demo.Product.Model.dto.ProductDTO;
import com.ucc.Demo.Product.Model.dto.ProductInfoDTO;
import com.ucc.Demo.Product.Model.entities.Product;
import com.ucc.Demo.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping("api/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    //Debajo responseEntity le pusieron Object, pero creo que es Product(?
    @PostMapping("api/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product>newProducts( @RequestBody Product product){
        return productService.newProduct(product);
    }

    //ACTIVIDADES
    @GetMapping("api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PatchMapping("/api/products/{id}")
    public ResponseEntity<Product>modifyProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.modifyProduct(id, product);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    //uso de DTO
    @GetMapping("api/product/info")
    @ResponseStatus(HttpStatus.OK)
    public  List<ProductInfoDTO>getProductDTO(){
        return productService.getAllInfoProducts();
    }

    @PostMapping("api/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object>newProductFromDTO(@RequestBody ProductDTO productDTO){
        return productService.newProductFromDTO(productDTO);
    }
}
