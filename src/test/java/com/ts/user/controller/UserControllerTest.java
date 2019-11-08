package com.ts.user.controller;

import com.ts.user.controller.v1.UserController;
import com.ts.user.entity.User;
import com.ts.user.service.v1.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    UserService userServiceMock;

   @InjectMocks
    UserController userController;

   @Test
    public void getById_Valid() {
        Optional<User> userModel = Optional.of(new User());
        Mockito.when(userServiceMock.getById()).thenReturn(userModel);
      ResponseEntity<User> user = userController.getById(1L);
      if(Objects.nonNull(user)){
          assertEquals(user.getStatusCodeValue(), HttpStatus.OK.value());
      }
    }

    @Test
    public void getById_InValid() {
        Optional<User> userModel = Optional.ofNullable(null);
        Mockito.when(userServiceMock.getById()).thenReturn(userModel);
        ResponseEntity<User> user = userController.getById(1L);
        if(Objects.nonNull(user)){
            assertEquals(user.getStatusCodeValue(), HttpStatus.NOT_FOUND.value());
        }
    }

    @Test
    public void getAll_NullValue() {
        List<User> userModels = new ArrayList<User>();
        Mockito.when(userServiceMock.findAll()).thenReturn(userModels);
        ResponseEntity<List<User>> users = userController.allUsers();
        if(Objects.nonNull(users)){
            assertEquals(users.getStatusCodeValue(), HttpStatus.NO_CONTENT.value());
        }
    }

    @Test
    public void getAll_OK_StatusCode() {
        List<User> userModels = new ArrayList<User>();
        userModels.add(mockUser());
        Mockito.when(userServiceMock.findAll()).thenReturn(userModels);
        ResponseEntity<List<User>> users = userController.allUsers();
        if(Objects.nonNull(users)){
            assertEquals(users.getStatusCodeValue(), HttpStatus.OK.value());
        }
    }

    @Test
    public void getAll_NO_Content_StatusCode() {
        List<User> userModels = new ArrayList<User>();
        //userModels.add(mockUser());
        Mockito.when(userServiceMock.findAll()).thenReturn(userModels);
        ResponseEntity<List<User>> users = userController.allUsers();
        if(Objects.nonNull(users)){
            assertEquals(users.getStatusCodeValue(), HttpStatus.NO_CONTENT.value());
        }
    }

    private User mockUser(){
       User user = new User();
       user.setId(1L);
       user.setLastName("L");
       user.setFirstName(("F"));
       return user;
    }



}
