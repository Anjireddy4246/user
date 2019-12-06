package com.ts.user.controller.v1;

import com.ts.user.entity.User;
import com.ts.user.model.v1.LoginModel;
import com.ts.user.model.v1.LoginResponseModel;
import com.ts.user.model.v1.UserModel;
import com.ts.user.service.v1.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AuthControllerV1")
@CrossOrigin
@RequestMapping(value = "/v1/")
public class AuthController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<LoginResponseModel> validateCredentials(@RequestBody LoginModel loginModel) {
        LoginResponseModel loginResponseModel = authService.login(loginModel);
        return ResponseEntity.ok(loginResponseModel);
    }

}
