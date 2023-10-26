package com.example.jwtspring_security.user.repository;

import com.example.jwtspring_security.user.model.entity.UserEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntitiy, Integer> {
    Optional<UserEntitiy> findByUserName(String userName);
}
