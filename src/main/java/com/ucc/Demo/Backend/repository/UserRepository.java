package com.ucc.Demo.Backend.repository;

import com.ucc.Demo.Backend.Model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
