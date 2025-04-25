package com.pragma.powerup_user.application.handler;

import com.pragma.powerup_user.application.dto.request.AuthenticationRequestDto;
import com.pragma.powerup_user.application.dto.response.AuthenticationResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAuthHandler {

    ResponseEntity<AuthenticationResponseDto> autenticate(AuthenticationRequestDto authenticationRequestDto);
}
