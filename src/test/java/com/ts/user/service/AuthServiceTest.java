package com.ts.user.service;

import com.ts.user.controller.v1.UserController;
import com.ts.user.entity.User;
import com.ts.user.model.v1.LoginModel;
import com.ts.user.model.v1.LoginResponseModel;
import com.ts.user.repository.v1.UserRepository;
import com.ts.user.service.impl.v1.AuthServiceImpl;
import com.ts.user.service.v1.AuthService;
import com.ts.user.service.v1.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {
    @Mock
    UserService userService;

    @InjectMocks
    @Qualifier("AuthServiceImplV1")
    AuthService authService = new AuthServiceImpl();

    @Test
    public void getById_Valid() {

        User userEntity = new User();
        userEntity.setFirstName("F");
        userEntity.setPassword("EWpvkVSrqVeiu7V8HN/O7epiL9d0od+MQz5fk6lF6JQ=");
        userEntity.setPasswordSalt("dHkFtHLn2igPZ5JJkHlJDg==");
        Optional<User> userModel = Optional.ofNullable(userEntity);
        LoginResponseModel loginResponseModel= loginResponseModel();
        LoginModel loginModel = new LoginModel();
        loginModel.setLoginId("technosoft");
        loginModel.setPassword("technosoft");
        loginModel.setAuthenticationType(1);
        Optional<User> user = userService.getByLoginId(loginModel.getLoginId());
        Mockito.when(userService.getByLoginId(loginModel.getLoginId()))
                .thenReturn(userModel);
//        Mockito.when(authService.login(loginModel))
//                .thenReturn(loginResponseModel());

        LoginResponseModel loginResponseModelResult =
                authService.login(loginModel);
        if(Objects.nonNull(loginResponseModelResult)){
            assertEquals(loginResponseModelResult.getAuthToken().length(),
                    UUID.randomUUID().toString().length());
        }
    }

    @Test
    public void getById_Invalid_Pwd() {

        User userEntity = new User();
        userEntity.setFirstName("F");
        userEntity.setPassword("EWpvkVSrqVeiu7V8HN/O7epiL9d0od+MQz5fk6lF6JQ=");
        userEntity.setPasswordSalt("dHkFtHLn2igPZ5JJkHlJDa==");
        Optional<User> userModel = Optional.ofNullable(userEntity);
        LoginResponseModel loginResponseModel= loginResponseModel();
        LoginModel loginModel = new LoginModel();
        loginModel.setLoginId("technosoft");
        loginModel.setPassword("technosoft");
        loginModel.setAuthenticationType(1);
        Optional<User> user = userService.getByLoginId(loginModel.getLoginId());
        Mockito.when(userService.getByLoginId(loginModel.getLoginId()))
                .thenReturn(userModel);
//        Mockito.when(authService.login(loginModel))
//                .thenReturn(loginResponseModel());

        LoginResponseModel loginResponseModelResult =
                authService.login(loginModel);
        if(Objects.nonNull(loginResponseModelResult)){
            assertEquals(loginResponseModelResult.getErrorMessage(),
                    "Invalid Credentials");
        }
    }

    @Test
    public void getById_Invalid_User() {

//        User userEntity = new User();
//        userEntity.setFirstName("F");
//        userEntity.setPassword("EWpvkVSrqVeiu7V8HN/O7epiL9d0od+MQz5fk6lF6JQ=");
//        userEntity.setPasswordSalt("dHkFtHLn2igPZ5JJkHlJDa==");
        Optional<User> userModel = Optional.ofNullable(null);
        LoginResponseModel loginResponseModel= loginResponseModel();
        LoginModel loginModel = new LoginModel();
        loginModel.setLoginId("technosoft");
        loginModel.setPassword("technosoft");
        loginModel.setAuthenticationType(1);
        Optional<User> user = userService.getByLoginId(loginModel.getLoginId());
        Mockito.when(userService.getByLoginId(loginModel.getLoginId()))
                .thenReturn(userModel);
//        Mockito.when(authService.login(loginModel))
//                .thenReturn(loginResponseModel());

        LoginResponseModel loginResponseModelResult =
                authService.login(loginModel);
        if(Objects.nonNull(loginResponseModelResult)){
            assertEquals(loginResponseModelResult.getErrorMessage(),
                    "Invalid Credentials");
        }
    }

    private LoginResponseModel loginResponseModel(){
        LoginResponseModel loginResponseModel = new LoginResponseModel();
        loginResponseModel.setAuthToken(UUID.randomUUID().toString());
        loginResponseModel.setErrorMessage("Invalid Credentials");
        return loginResponseModel;
    }
}
