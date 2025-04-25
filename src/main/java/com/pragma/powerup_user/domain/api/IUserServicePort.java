package com.pragma.powerup_user.domain.api;

import com.pragma.powerup_user.domain.model.UserModel;

import java.util.Map;

public interface IUserServicePort {

    void saveOwner(UserModel userModel, Map<String, String> header);
}
