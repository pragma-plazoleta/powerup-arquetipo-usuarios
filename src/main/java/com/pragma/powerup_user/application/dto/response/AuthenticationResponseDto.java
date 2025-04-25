package com.pragma.powerup_user.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AuthenticationResponseDto {

    private String jwtken;

}
