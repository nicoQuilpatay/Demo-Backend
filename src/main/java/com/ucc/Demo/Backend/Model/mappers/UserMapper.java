package com.ucc.Demo.Backend.Model.mappers;

import com.ucc.Demo.Backend.Model.dto.UserDTO;
import com.ucc.Demo.Backend.Model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userDTOToUserEntity(UserDTO userDTO ){
        User userEntity = new User();
        userEntity.setId(userDTO.getId());
        return userEntity;
    }

    public UserDTO UserEntityToUserDTO(User userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        return  userDTO;
    }
}
