package com.pragma.powerup_user.domain.usecase;

import com.pragma.powerup_user.domain.api.IAuthServicePort;
import com.pragma.powerup_user.domain.model.AuthenticationTokenModel;
import com.pragma.powerup_user.domain.model.AuthenticationUserModel;
import com.pragma.powerup_user.domain.model.UserModel;
import com.pragma.powerup_user.domain.spi.ISecurityPort;
import com.pragma.powerup_user.domain.spi.IUserPersistencePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AuthUseCase implements IAuthServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final ISecurityPort securityPort;

    public AuthUseCase(IUserPersistencePort userPersistencePort, ISecurityPort securityPort) {
        this.userPersistencePort = userPersistencePort;
        this.securityPort = securityPort;
    }

    @Override
    public ResponseEntity<String> autenticateUser(AuthenticationUserModel authenticationUserModel) {

        UserModel userAuthentication = userPersistencePort.findByCorreo(authenticationUserModel.getUserName());

        if (!userAuthentication.getCorreo().equalsIgnoreCase(authenticationUserModel.getUserName()) || !userAuthentication.getClave().equalsIgnoreCase(authenticationUserModel.getPsswrd()) ) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<String>(securityPort.generateToken(userAuthentication.getNombre(), userAuthentication.getRol(), userAuthentication.getNumeroDocumento()), HttpStatus.CREATED);
    }
}
