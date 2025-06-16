package com.ucc.Demo.Product.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO implements Serializable {
    private String name;
    private Double price;
    private Integer stock;
    private CategoryDTO categoryDTO;
}
