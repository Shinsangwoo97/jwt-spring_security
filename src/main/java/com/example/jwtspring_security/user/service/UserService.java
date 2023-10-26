package com.example.jwtspring_security.user.service;

import com.example.jwtspring_security.user.exception.ApplicationException;
import com.example.jwtspring_security.user.exception.ErrorCode;
import com.example.jwtspring_security.user.model.User;
import com.example.jwtspring_security.user.model.entity.UserEntitiy;
import com.example.jwtspring_security.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityRepository userEntityRepository;
public User join(String userName, String password) {
   //회원가입하려는 userName으로 회원가입된 user가 있는지
    userEntityRepository.findByUserName(userName).ifPresent(it -> {
        throw new ApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
    });

    // 회원가입 진행 = user를 등록
        UserEntitiy userEntitiy = userEntityRepository.save(UserEntitiy.of(userName, password));
    return User.fromEntity(userEntitiy);
}
public String login(String userName, String password) {
    // 회원가입 여부 체크
    UserEntitiy userEntitiy = userEntityRepository.findByUserName(userName).orElseThrow(()->new ApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));
    // 비밀번호 체크
    if(!userEntitiy.getPassword().equals(password)){
        throw new ApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
    }
    // 토큰 생성
    return "";
    }
}
