package com.pragma.powerup_user.domain.usecase;

import com.pragma.powerup_user.DummyMock;
import com.pragma.powerup_user.domain.model.UserModel;
import com.pragma.powerup_user.domain.spi.IBCryptPort;
import com.pragma.powerup_user.domain.spi.ISecurityPort;
import com.pragma.powerup_user.domain.spi.IUserPersistencePort;
import com.pragma.powerup_user.domain.util.Constans;
import com.pragma.powerup_user.domain.validate.UserValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserUseCaseTest {

    private IUserPersistencePort userPersistencePort;
    private UserValidate userValidate;
    private ISecurityPort securityPort;
    private IBCryptPort bCryptPort;
    private UserUseCase userUseCase;
    private DummyMock dummyMock;

    @BeforeEach
    void setUp() {
        userPersistencePort = mock(IUserPersistencePort.class);
        userValidate = mock(UserValidate.class);
        securityPort = mock(ISecurityPort.class);
        bCryptPort = mock(IBCryptPort.class);
        userUseCase = new UserUseCase(userPersistencePort, userValidate, securityPort, bCryptPort);
        dummyMock = new DummyMock();
    }

    @Test
    void saveOwner() {
        UserModel userModel = dummyMock.getSuccessUserModel();
        Map<String, String> headers = new HashMap<>();
        headers.put("authorization", "Bearer token-test");

        Mockito.when(securityPort.getRolFromToken("Bearer token-test")).thenReturn(Constans.ROL_ADMINISTRADOR);
        Mockito.when(bCryptPort.encryptPsswrd("Contraseña")).thenReturn("$2a$12$rsRntN3BCMcXvnRfFoGF/eqZyrmu6CDbLtjE5qmvXD6T0xBQjno06");

        userUseCase.saveOwner(userModel, headers);

        verify(userValidate).validateDataNotNull(userModel);
        verify(userValidate).validateDocumentNumber(userModel.getNumeroDocumento());
        verify(userValidate).validatePhoneNumber(userModel.getCelular());
        verify(userValidate).validateUserIsOlder(userModel);
        verify(userValidate).validateEmail(userModel.getCorreo());
        verify(bCryptPort).encryptPsswrd("Contraseña");
        verify(userPersistencePort).saveOwner(userModel);

    }
}