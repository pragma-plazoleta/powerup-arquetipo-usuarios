package com.pragma.powerup_user.application.dto.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationResponseDtoTest {

    @Test
    void dtoGetterAndSetterTest() {

        AuthenticationResponseDto responseDto = new AuthenticationResponseDto();
        String expectResponse = "token-test";

        responseDto.setJwtken(expectResponse);

        Assertions.assertEquals(expectResponse, responseDto.getJwtken());

    }
}