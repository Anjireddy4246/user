package com.ts.user.controller;

import com.ts.user.controller.v1.AuthController;
import com.ts.user.controller.v1.RoleController;
import com.ts.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoleControllerTest {

    @InjectMocks
    RoleController roleController = new RoleController();

    @Test
    public void getRoleName_Valid() {
       // Mockito.when(userServiceMock.getById()).thenReturn(userModel);
        ResponseEntity<String> roleName = roleController.getRoleName();
        if(Objects.nonNull(roleName)){
            assertEquals(roleName.getStatusCodeValue(), HttpStatus.OK.value());
        }
    }

}
