package com.ucc.Demo.Backend.service;

import com.ucc.Demo.Backend.Model.dto.PetDTO;
import com.ucc.Demo.Backend.Model.dto.UserDTO;
import com.ucc.Demo.Backend.Model.entities.Pet;
import com.ucc.Demo.Backend.Model.entities.User;
import com.ucc.Demo.Backend.Model.mappers.UserMapper;
import com.ucc.Demo.Backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity <User> newUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // implementacion de DTO, este DTo devuelve el nombre del user y su id
    public List<UserDTO> getAllInfoUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> new UserDTO(userEntity.getId(),userEntity.getEmail(),userEntity.getName(),userEntity.getPassword()))
                .collect(Collectors.toList());

    }

    //Crear user desde DTO
    public ResponseEntity<Object> newUserFromDTO(UserDTO userDTO ){
        User userEntity = userMapper.userDTOToUserEntity(userDTO);
        userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
