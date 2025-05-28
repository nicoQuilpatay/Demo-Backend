package com.ucc.Demo.Backend.Model.entities;
import jakarta.persistence.*;

@Entity
@Table (name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Boolean status;
    private Integer stock;
    private String description;

    public Product() {}

    public Product(Long id, String name, Double price, Boolean status,Integer stock, String description ) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.status = status;
    this.stock = stock;
    this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
