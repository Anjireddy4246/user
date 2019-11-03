package com.ts.user.model.v1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class LoginModel {
    @Getter @Setter
    private String loginId;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private Integer authenticationType;
}
