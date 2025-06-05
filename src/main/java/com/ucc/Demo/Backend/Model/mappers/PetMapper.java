package com.ucc.Demo.Backend.Model.mappers;

import com.ucc.Demo.Backend.Model.dto.PetDTO;
import com.ucc.Demo.Backend.Model.entities.Pet;
import com.ucc.Demo.Backend.Model.entities.User;
import com.ucc.Demo.Backend.repository.UserRepository;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    private final UserRepository userRepository;

    public PetMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Pet petDTOToPetEntity(PetDTO petDTO){
        Pet petEntity = new Pet();
        petEntity.setName(petDTO.getName());
        petEntity.setId(petDTO.getId());
        petEntity.setDescription("creado por mapper");

        User userEntity = userRepository.findOneById(petDTO.getUserDTO().getId());
        petEntity.setUser(userEntity);
        return petEntity;
    }

    public PetDTO PetEntityToPetDTO(Pet petEntity){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(petEntity.getId());
        petDTO.setName(petEntity.getName());
        return  petDTO;
    }
}
