package com.ts.user.service.impl.v1;

import com.ts.user.entity.User;
import com.ts.user.model.v1.LoginModel;
import com.ts.user.model.v1.LoginResponseModel;
import com.ts.user.service.v1.AuthService;
import com.ts.user.service.v1.UserService;
import com.ts.user.shared.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("AuthServiceImplV1")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public LoginResponseModel login(LoginModel loginModel) {
        Optional<User> user = userService.getByLoginId(loginModel.getLoginId());
        LoginResponseModel loginResponseModel = new LoginResponseModel();
        boolean isValid = false;
        if (user.isPresent()) {
            User userInfo = user.get();
            isValid = PasswordUtil.validatePassword(loginModel.getPassword(),
                    userInfo.getPasswordSalt(), userInfo.getPassword());
        }
        if (isValid) {
            loginResponseModel.setAuthToken(UUID.randomUUID().toString());
        } else {
            loginResponseModel.setErrorMessage("Invalid Credentials");
        }
        return loginResponseModel;
    }
}
