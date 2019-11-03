package com.ts.user.model.v1;


import lombok.Getter;
import lombok.Setter;

public class LoginResponseModel {
    @Getter @Setter
    private String authToken;
    @Getter @Setter
    private String errorMessage;
}
