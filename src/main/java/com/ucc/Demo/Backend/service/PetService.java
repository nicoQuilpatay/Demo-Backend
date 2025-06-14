package com.ucc.Demo.Backend.service;


import com.ucc.Demo.Backend.Model.dto.PetDTO;
import com.ucc.Demo.Backend.Model.entities.Pet;
import com.ucc.Demo.Backend.Model.mappers.PetMapper;
import com.ucc.Demo.Backend.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;


    public PetService(PetRepository petRepository, PetMapper petMapper){
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public List<Pet> getPets(){ return petRepository.findAll();}

    public ResponseEntity <Pet> newPet (Pet pet){
        petRepository.save(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // implementacion de DTO, este DTo devuelve el nombre del pet y su id
    public List<PetDTO> getAllInfoPets() {
        return petRepository.findAll()
                .stream()
                .map(petEntity -> new PetDTO(petEntity.getId(), petEntity.getName(), petEntity.getUser()))
                .collect(Collectors.toList());

    }

    //Crear pet desde DTO
    public ResponseEntity<Object> newPetFromDTO(PetDTO petDTO){
        Pet petEntity = petMapper.petDTOToPetEntity(petDTO);
        petRepository.save(petEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
