package com.ucc.Demo.Backend.service;


import com.ucc.Demo.Backend.Model.entities.Pet;
import com.ucc.Demo.Backend.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<Pet> getPets(){ return petRepository.findAll();}

    public ResponseEntity <Pet> newPet (Pet pet){
        petRepository.save(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
