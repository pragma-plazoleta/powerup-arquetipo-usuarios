package com.pragma.powerup_user.application.handler.impl;

import com.pragma.powerup_user.application.dto.response.AuthenticationResponseDto;
import com.pragma.powerup_user.application.mapper.request.IAuthenticationRequestMapper;
import com.pragma.powerup_user.domain.api.IAuthServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AuthHandlerTest {

    private AuthHandler authHandler;
    private IAuthServicePort authServicePort;
    private IAuthenticationRequestMapper authenticationRequestMapper;
    private AuthenticationResponseDto authenticationResponseDto;

    @BeforeEach
    void setUp() {
        authServicePort = mock(IAuthServicePort.class);
        authenticationRequestMapper = mock(IAuthenticationRequestMapper.class);
        authenticationResponseDto = new AuthenticationResponseDto();
        authHandler = new AuthHandler(authServicePort, authenticationRequestMapper, authenticationResponseDto);
    }

    @Test
    void autenticate() {


    }
}