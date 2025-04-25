package com.pragma.powerup_user.domain.usecase;

import com.pragma.powerup_user.domain.api.IUserServicePort;
import com.pragma.powerup_user.domain.model.UserModel;
import com.pragma.powerup_user.domain.spi.IBCryptPort;
import com.pragma.powerup_user.domain.spi.ISecurityPort;
import com.pragma.powerup_user.domain.spi.IUserPersistencePort;
import com.pragma.powerup_user.domain.util.Constans;
import com.pragma.powerup_user.domain.validate.UserValidate;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort iUserPersistencePort;
    private final UserValidate userValidate;
    private final ISecurityPort rolSecurityPort;
    private final IBCryptPort bCryptPort;

    public UserUseCase(IUserPersistencePort iUserPersistencePort, UserValidate userValidate, ISecurityPort rolSecurityPort, IBCryptPort bCryptPort) {
        this.iUserPersistencePort = iUserPersistencePort;
        this.userValidate = userValidate;
        this.rolSecurityPort = rolSecurityPort;
        this.bCryptPort = bCryptPort;
    }

    @Override
    public void saveOwner(UserModel userModel, Map<String, String> header) {

        userValidate.validateDataNotNull(userModel);
        userValidate.validateDocumentNumber(userModel.getNumeroDocumento());
        userValidate.validatePhoneNumber(userModel.getCelular());
        userValidate.validateUserIsOlder(userModel);
        userValidate.validateEmail(userModel.getCorreo());

        userModel.setClave(bCryptPort.encryptPsswrd(userModel.getClave()));

        Integer rol = rolSecurityPort.getRolFromToken(header.get(Constans.AUTHORIZATION_HEADER.toLowerCase()));

        if (rol == Constans.ROL_ADMINISTRADOR) {
            iUserPersistencePort.saveOwner(userModel);
        }

    }
}
