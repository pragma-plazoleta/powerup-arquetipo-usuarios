package com.pragma.powerup_user.domain.api;

import com.pragma.powerup_user.domain.model.AuthenticationUserModel;
import org.springframework.http.ResponseEntity;

public interface IAuthServicePort {

    ResponseEntity<String> autenticateUser(AuthenticationUserModel authenticationUserModel);

}
