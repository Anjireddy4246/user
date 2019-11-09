//package com.ts.user.service;
//
//import com.ts.user.entity.User;
//import com.ts.user.model.v1.LoginModel;
//import com.ts.user.model.v1.LoginResponseModel;
//import com.ts.user.repository.v1.UserRepository;
//import com.ts.user.service.impl.v1.AuthServiceImpl;
//import com.ts.user.service.impl.v1.UserServiceImpl;
//import com.ts.user.service.v1.AuthService;
//import com.ts.user.service.v1.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import java.util.Objects;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    @InjectMocks
//    UserService userService = new UserServiceImpl();
//
//    @Mock
//    UserRepository userRepository;
//
//
//    @Test
//    public void getById_Invalid_Pwd() {
//
//        User userEntity = new User();
//        userEntity.setFirstName("F");
//        userEntity.setPassword("EWpvkVSrqVeiu7V8HN/O7epiL9d0od+MQz5fk6lF6JQ=");
//        userEntity.setPasswordSalt("dHkFtHLn2igPZ5JJkHlJDa==");
//        Optional<User> userModel = Optional.ofNullable(userEntity);
//        //Optional<User> user = userService.getByLoginId(loginModel.getLoginId());
//        Mockito.when(userRepository.findById(1L))
//                .thenReturn(userModel);
//
//        userModel = userService.getById();
//        assertEquals(userModel.get().getFirstName(),"F");
//    }
//}
