package com.ucc.Demo.Products.Model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductInfoDTO implements Serializable {

    private Long id;
    private String name;
    private String description;


}
