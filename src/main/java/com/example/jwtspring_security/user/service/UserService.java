package com.example.jwtspring_security.user.service;

import com.example.jwtspring_security.SIMPLE_JWT.JwtToken;
import com.example.jwtspring_security.user.exception.ApplicationException;
import com.example.jwtspring_security.user.exception.ErrorCode;
import com.example.jwtspring_security.user.model.User;
import com.example.jwtspring_security.user.model.entity.UserEntitiy;
import com.example.jwtspring_security.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.secret-key}")
    private String secretkey;
    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    @Transactional
    public User join(String userName, String password) {
   //회원가입하려는 userName으로 회원가입된 user가 있는지
    userEntityRepository.findByUserName(userName).ifPresent(it -> {
        throw new ApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
    });
    // 회원가입 진행 = user를 등록
    UserEntitiy userEntitiy = userEntityRepository.save(UserEntitiy.of(userName, encoder.encode(password)));
    return User.fromEntity(userEntitiy);
}
public String login(String userName, String password) {
    // 회원가입 여부 체크
    UserEntitiy userEntitiy = userEntityRepository.findByUserName(userName).orElseThrow(()->new ApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));
    // 비밀번호 체크
    if(!encoder.matches(password, userEntitiy.getPassword())){
        throw new ApplicationException(ErrorCode.INVALID_PASSWORD, "");
    }
    // 토큰 생성
    String token = JwtToken.generateToken(userName, secretkey, expiredTimeMs);
    return token;
    }
}
