package com.pragma.powerup_user.application.handler;

import com.pragma.powerup_user.application.dto.request.UserRequestDto;

import java.util.Map;

public interface IUserHandler {

    void saveOwner(UserRequestDto userRequestDto, Map<String, String> header);

}
