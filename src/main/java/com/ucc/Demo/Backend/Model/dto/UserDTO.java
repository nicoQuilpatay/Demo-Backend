package com.ucc.Demo.Backend.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO implements Serializable {
    private Long id;
    private String email;
    private String name;
    private String password;

    public UserDTO(Long id) {
    }
}
