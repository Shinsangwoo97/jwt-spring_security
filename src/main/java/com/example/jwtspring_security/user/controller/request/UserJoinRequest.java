package com.example.jwtspring_security.user.controller.request;

import lombok.Getter;

@Getter
public class UserJoinRequest {
    private String userName;
    private String password;

}
