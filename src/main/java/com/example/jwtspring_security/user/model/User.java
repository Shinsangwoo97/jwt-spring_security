package com.example.jwtspring_security.user.model;

import com.example.jwtspring_security.user.model.entity.UserEntitiy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static User fromEntity(UserEntitiy entitiy) {
        return new User(
                entitiy.getId(),
                entitiy.getUserName(),
                entitiy.getPassword(),
                entitiy.getRole(),
                entitiy.getRegisterAt(),
                entitiy.getUpdatedAt(),
                entitiy.getDeletedAt()
        );
    }
}
