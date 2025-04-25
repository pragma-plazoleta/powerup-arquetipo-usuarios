package com.pragma.powerup_user.application.handler.impl;

import com.pragma.powerup_user.DummyMock;
import com.pragma.powerup_user.application.dto.request.UserRequestDto;
import com.pragma.powerup_user.application.mapper.request.IUserRequestMapper;
import com.pragma.powerup_user.domain.api.IUserServicePort;
import com.pragma.powerup_user.domain.model.UserModel;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserHandlerTest {

    private UserHandler userHandler;
    private IUserServicePort userServicePort;
    private IUserRequestMapper userRequestMapper;
    private DummyMock dummyMock;

    @BeforeEach
    void setup() {
        userServicePort = mock(IUserServicePort.class);
        userRequestMapper = mock(IUserRequestMapper.class);
        userHandler = new UserHandler(userServicePort, userRequestMapper);
        dummyMock = new DummyMock();
    }

    @Test
    void saveOwner() {

        Map<String, String> headers =  new HashMap<>();
        UserRequestDto userRequestDto = dummyMock.getSuccessUserRequestDto();
        UserModel userModel = new UserModel();

        Mockito.when(userRequestMapper.toUser(userRequestDto)).thenReturn(userModel);
        userHandler.saveOwner(userRequestDto, headers);

        verify(userServicePort, times(1)).saveOwner(userModel, headers);

    }
}