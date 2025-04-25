package com.pragma.powerup_user.domain.spi;

import com.pragma.powerup_user.domain.model.UserModel;

public interface IUserPersistencePort {

    UserModel saveOwner(UserModel userModel);

    UserModel findByCorreo(String userName);

}
