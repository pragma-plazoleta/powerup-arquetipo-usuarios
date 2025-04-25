package com.pragma.powerup_user.application.handler.impl;

import com.pragma.powerup_user.application.dto.request.AuthenticationRequestDto;
import com.pragma.powerup_user.application.dto.response.AuthenticationResponseDto;
import com.pragma.powerup_user.application.handler.IAuthHandler;
import com.pragma.powerup_user.application.mapper.request.IAuthenticationRequestMapper;
import com.pragma.powerup_user.domain.api.IAuthServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AuthHandler implements IAuthHandler {

    private final IAuthServicePort authServicePort;
    private final IAuthenticationRequestMapper authenticationRequestMapper;
    private final AuthenticationResponseDto authenticationResponseDto;

    public AuthHandler(IAuthServicePort authServicePort, IAuthenticationRequestMapper authenticationRequestMapper, AuthenticationResponseDto authenticationResponseDto) {
        this.authServicePort = authServicePort;
        this.authenticationRequestMapper = authenticationRequestMapper;
        this.authenticationResponseDto = authenticationResponseDto;
    }

    @Override
    public ResponseEntity<AuthenticationResponseDto> autenticate(AuthenticationRequestDto authenticationRequestDto) {

        ResponseEntity<String> token = authServicePort.autenticateUser(authenticationRequestMapper.toModel(authenticationRequestDto));
        authenticationResponseDto.setJwtken(token.getBody());

        return new ResponseEntity<>(authenticationResponseDto, HttpStatus.CREATED);
    }
}
