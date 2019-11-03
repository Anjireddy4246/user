package com.ts.user.service.v1;

import com.ts.user.model.v1.LoginModel;
import com.ts.user.model.v1.LoginResponseModel;

public interface AuthService {
    LoginResponseModel login(LoginModel loginModel);
}