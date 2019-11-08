package com.ts.user.controller;

import com.ts.user.controller.v1.AuthController;
import com.ts.user.controller.v1.UserController;
import com.ts.user.entity.User;
import com.ts.user.model.v1.LoginModel;
import com.ts.user.model.v1.LoginResponseModel;
import com.ts.user.service.v1.AuthService;
import com.ts.user.service.v1.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {
    @Mock
    AuthService authServiceMock;

    @InjectMocks
    AuthController authController;

    @Test
    public void getById_Valid() {
        LoginResponseModel loginResponseModel= new LoginResponseModel();
        LoginModel loginModel = new LoginModel();
        loginModel.setLoginId("TS");
        loginModel.setPassword("TS");
        loginModel.setAuthenticationType(1);
        Mockito.when(authServiceMock.login(loginModel)).thenReturn(loginResponseModel);
        ResponseEntity<LoginResponseModel> loginResponseModelResult =
                authController.validateCredentials(loginModel);
        if(Objects.nonNull(loginResponseModelResult)){
            assertEquals(loginResponseModelResult.getStatusCodeValue(), HttpStatus.OK.value());
        }
    }

    @Test
    public void getById_InValid() {
        LoginResponseModel loginResponseModel= new LoginResponseModel();
        LoginModel loginModel = new LoginModel();
        loginModel.setLoginId("TS");
        loginModel.setPassword("TS");
        loginResponseModel.setAuthToken(UUID.randomUUID().toString());
        loginResponseModel.setErrorMessage("Invalid Credentials");
        loginModel.setAuthenticationType(1);
        Mockito.when(authServiceMock.login(loginModel)).thenReturn(loginResponseModel);
        ResponseEntity<LoginResponseModel> loginResponseModelResult =
                authController.validateCredentials(loginModel);
        if(Objects.nonNull(loginResponseModelResult)){
            assertEquals(loginResponseModelResult.getBody().getErrorMessage(), "Invalid Credentials");
        }
    }

}
