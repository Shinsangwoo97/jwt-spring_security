package com.example.jwtspring_security.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginRequest {
    private String userName;
    private String password;

}
