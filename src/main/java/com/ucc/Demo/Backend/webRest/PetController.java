package com.ucc.Demo.Backend.webRest;

import com.ucc.Demo.Backend.Model.dto.PetDTO;
import com.ucc.Demo.Backend.Model.entities.Pet;
import com.ucc.Demo.Backend.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petservice;

    @GetMapping("api/pet")
    @ResponseStatus(HttpStatus.OK)
    public List<Pet> getPets(){
        return petservice.getPets();
    }



    @PostMapping("api/pet")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pet> newPet(@RequestBody Pet pet){
        return petservice.newPet(pet);
    }

    //Uso de DTO
    @GetMapping("api/pet/info")
    @ResponseStatus(HttpStatus.OK)
    public  List<PetDTO>getPetDTO(){
        return petservice.getAllInfoPets();
    }

    @PostMapping("api/pet/dto")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object>newPetFromDTO(@RequestBody PetDTO petDTO){
        return petservice.newPetFromDTO(petDTO);
    }


}

