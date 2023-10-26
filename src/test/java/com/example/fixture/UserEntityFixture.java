package com.example.fixture;

import com.example.jwtspring_security.user.model.entity.UserEntitiy;

public class UserEntityFixture {
    public static UserEntitiy get(String userName, String password) {
        UserEntitiy result = new UserEntitiy();
        result.setId(1);
        result.setUserName(userName);
        result.setPassword(password);
        return result;
    }
}
