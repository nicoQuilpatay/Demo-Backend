package com.ucc.Demo.Backend.webRest;

import com.ucc.Demo.Backend.Model.dto.PetDTO;
import com.ucc.Demo.Backend.Model.dto.UserDTO;
import com.ucc.Demo.Backend.Model.entities.User;
import com.ucc.Demo.Backend.repository.UserRepository;
import com.ucc.Demo.Backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


//    @PostMapping("api/user")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity <User>newUser(@RequestBody User user){
//        return userService.newUser(user);
//    }

    @GetMapping("api/user")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    //Uso de DTO
    @GetMapping("api/user/info")
    @ResponseStatus(HttpStatus.OK)
    public  List<UserDTO>getUserDTO(){
        return userService.getAllInfoUsers();
    }

    @PostMapping("api/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object>newUserFromDTO(@RequestBody UserDTO userDTO){
        return userService.newUserFromDTO(userDTO);
    }

}
