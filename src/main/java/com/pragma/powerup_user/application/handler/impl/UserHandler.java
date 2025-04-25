package com.pragma.powerup_user.application.handler.impl;

import com.pragma.powerup_user.application.dto.request.UserRequestDto;
import com.pragma.powerup_user.application.handler.IUserHandler;
import com.pragma.powerup_user.application.mapper.request.IUserRequestMapper;
import com.pragma.powerup_user.domain.validate.UserValidate;
import com.pragma.powerup_user.domain.api.IUserServicePort;
import com.pragma.powerup_user.domain.model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort iUserServicePort;
    private final IUserRequestMapper iUserRequestMapper;

    public UserHandler(IUserServicePort iUserServicePort, IUserRequestMapper iUserRequestMapper) {
        this.iUserServicePort = iUserServicePort;
        this.iUserRequestMapper = iUserRequestMapper;
    }

    @Override
    public void saveOwner(UserRequestDto userRequestDto, Map<String, String> header) {
        UserModel userModel = iUserRequestMapper.toUser(userRequestDto);
        iUserServicePort.saveOwner(userModel, header);
    }
}
