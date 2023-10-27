package com.example.jwtspring_security.user.controller;

import com.example.jwtspring_security.user.controller.request.UserJoinRequest;
import com.example.jwtspring_security.user.controller.request.UserLoginRequest;
import com.example.jwtspring_security.user.controller.response.Response;
import com.example.jwtspring_security.user.controller.response.UserJoinResponse;
import com.example.jwtspring_security.user.controller.response.UserLoginResponse;
import com.example.jwtspring_security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

private final UserService userService;
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request){
        return Response.success(UserJoinResponse.fromUser(userService.join(request.getUserName(), request.getPassword())));
    }
    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request){
        String token = userService.login(request.getUserName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }
}
