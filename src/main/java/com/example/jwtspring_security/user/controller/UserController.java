package com.example.jwtspring_security.user.controller;

import com.example.jwtspring_security.user.controller.request.UserJoinRequest;
import com.example.jwtspring_security.user.controller.response.Response;
import com.example.jwtspring_security.user.controller.response.UserJoinResponse;
import com.example.jwtspring_security.user.model.User;
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
    @PostMapping("join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request){
        User user = userService.join(request.getUserName(), request.getPassword());
        return Response.success(UserJoinResponse.fromUser(user));
    }
}
