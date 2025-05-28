package com.ucc.Demo.Backend.repository;


import com.ucc.Demo.Backend.Model.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
