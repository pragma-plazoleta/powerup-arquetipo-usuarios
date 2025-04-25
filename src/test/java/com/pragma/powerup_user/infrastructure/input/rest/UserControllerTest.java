package com.pragma.powerup_user.infrastructure.input.rest;

import com.pragma.powerup_user.application.dto.request.UserRequestDto;
import com.pragma.powerup_user.application.handler.IUserHandler;
import com.pragma.powerup_user.infrastructure.util.InfraConstans;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    private UserController userController;
    private IUserHandler userHandler;

    @BeforeEach
    void setup() {
        userHandler = mock(IUserHandler.class);
        userController = new UserController(userHandler);
    }

    @Test
    void saveOwner() {
        UserRequestDto userRequestDto = new UserRequestDto();
        Map<String, String> headers =  new HashMap<>();

        ResponseEntity<String> expectResponse = new ResponseEntity<>(InfraConstans.RESPONSE_CREATE_OWNER, HttpStatus.CREATED);
        doNothing().when(userHandler).saveOwner(userRequestDto, headers);

        assertEquals(userController.saveOwner(userRequestDto, headers), expectResponse);
        verify(userHandler, times(1)).saveOwner(userRequestDto, headers);
    }
}