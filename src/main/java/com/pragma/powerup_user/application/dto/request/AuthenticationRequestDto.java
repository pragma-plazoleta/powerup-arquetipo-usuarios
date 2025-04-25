package com.pragma.powerup_user.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDto {

    private String userName;
    private String psswrd;

}
