package com.ucc.Demo.Backend.Model.dto;

import com.ucc.Demo.Backend.Model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class PetDTO {

    private Long id;
    private String name;
    private UserDTO userDTO;

    public PetDTO(Long id, String name, User user) {
    }
}

