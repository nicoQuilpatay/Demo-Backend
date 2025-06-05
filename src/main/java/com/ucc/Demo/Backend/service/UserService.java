package com.ucc.Demo.Backend.service;

import com.ucc.Demo.Backend.Model.entities.User;
import com.ucc.Demo.Backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity <User> newUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
