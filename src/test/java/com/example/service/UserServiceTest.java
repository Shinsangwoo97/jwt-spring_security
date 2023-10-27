//package com.example.service;
//
//import com.example.fixture.UserEntityFixture;
//import com.example.jwtspring_security.user.model.entity.UserEntitiy;
//import com.example.jwtspring_security.user.repository.UserEntityRepository;
//import com.example.jwtspring_security.user.service.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class UserServiceTest {
//    private UserService userService;
//    @MockBean
//    private UserEntityRepository userEntityRepository;
//    private UserEntityFixture userEntityFixture;
//
//    @Test
//    void 회원가입이_정상적으로_동작하는_경우(){
//    String userName = "userName";
//    String password = "password";
//    //mocking
//    when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
//    when(userEntityRepository.save(ArgumentMatchers.any())).thenReturn(Optional.of(userEntityFixture.get(userName, password)));
//
//    Assertions.assertDoesNotThrow(()->userService.join(userName, password));
//}
//@Test
//    void 회원가입시_userName으로_회원가입한_유저가_이미_있는경우(){
//    String userName = "userName";
//    String password = "password";
//    UserEntitiy fixture = userEntityFixture.get(userName, password);
//
//    //mocking
//    when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
//    when(userEntityRepository.save(ArgumentMatchers.any())).thenReturn(Optional.of(Mockito.mock(UserEntitiy.class)));
//
//    Assertions.assertThrows(RuntimeException.class, ()->userService.join(userName, password));
//}
//@Test
//    void 로그인이_정상적으로_동작하는_경우(){
//    String userName = "userName";
//    String password = "password";
//
//    UserEntitiy fixture = userEntityFixture.get(userName, password);
//
//    when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
//    Assertions.assertDoesNotThrow(()->userService.login(userName, password));
//}
//@Test
//    void 로그인시_userName으로_회원가입한_유저가_이미_없는경우(){
//    String userName = "userName";
//    String password = "password";
//
//    //mocking
//    when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
//
//    Assertions.assertThrows(RuntimeException.class, ()->userService.login(userName, password));
//}
//@Test
//    void 로그인시_password가_틀린경우(){
//    String userName = "userName";
//    String password = "password";
//    String wrongPassword = "wrongPassword";
//    UserEntitiy fixture = userEntityFixture.get(userName, password);
//
//
//    //mocking
//    when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
//
//    Assertions.assertThrows(RuntimeException.class, ()->userService.login(userName, wrongPassword));
//}
//}
