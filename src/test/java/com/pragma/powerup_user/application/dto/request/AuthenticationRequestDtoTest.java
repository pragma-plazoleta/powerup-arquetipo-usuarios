package com.pragma.powerup_user.application.dto.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRequestDtoTest {

    @Test
    void dtoGetterAndSetterTest() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();

        String userName = "userTest";
        String psswrd = "Test123";

        authenticationRequestDto.setUserName(userName);
        authenticationRequestDto.setPsswrd(psswrd);

        Assertions.assertEquals(userName, authenticationRequestDto.getUserName());
        Assertions.assertEquals(psswrd, authenticationRequestDto.getPsswrd());

    }
}