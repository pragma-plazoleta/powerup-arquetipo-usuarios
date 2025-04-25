package com.pragma.powerup_user.domain.validate;

import com.pragma.powerup_user.domain.exception.InvalidDocumentNumberException;
import com.pragma.powerup_user.domain.exception.InvalidEmailException;
import com.pragma.powerup_user.domain.exception.InvalidPhoneNumberException;
import com.pragma.powerup_user.domain.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserValidateTest {

    private UserValidate userValidate;

    @BeforeEach
    void setUp() {
        userValidate = new UserValidate();
    }

    @Test
    void validateDataNotNull() {
        UserModel userModel = new UserModel();
        userModel.setId(null);
        userModel.setNombre("Juan");
        userModel.setApellido("Ruiz");
        userModel.setClave("Contraseña");
        userModel.setRol(2L);

        assertDoesNotThrow(() -> userValidate.validateDataNotNull(userModel));
    }

    @Test
    void throwExceptionWhenNameIsNull() {
        UserModel userModel = new UserModel();
        userModel.setNombre(null);
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateDataNotNull(userModel));
        userModel.setNombre("");
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateDataNotNull(userModel));
    }

    @Test
    void throwExceptionWhenLastNameIsNull() {
        UserModel userModel = new UserModel();
        userModel.setNombre("Juan");
        userModel.setApellido(null);
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateDataNotNull(userModel));
    }

    @Test
    void throwExceptionWhenPassIsNull() {
        UserModel userModel = new UserModel();
        userModel.setNombre("Juan");
        userModel.setApellido("Ruiz");
        userModel.setClave(null);
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateDataNotNull(userModel));
    }

    @Test
    void throwExceptionWhenRolIsNull() {
        UserModel userModel = new UserModel();
        userModel.setNombre("Juan");
        userModel.setApellido("Ruiz");
        userModel.setClave("Contraseña");
        userModel.setRol(null);
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateDataNotNull(userModel));
    }

    @Test
    void validateDocumentNumber() {
        assertDoesNotThrow(() -> userValidate.validateDocumentNumber("1019001001"));
    }

    @Test
    void throwExceptionWhenDocumentNumberIsInvalid() {
        assertThrows(InvalidDocumentNumberException.class, () -> userValidate.validateDocumentNumber("1019001oo1"));
    }

    @Test
    void validatePhoneNumber() {
        assertDoesNotThrow(() -> userValidate.validatePhoneNumber("+573192192505"));
    }

    @Test
    void throwExceptionWhenPhoneIsInvalidFormat() {
        assertThrows(InvalidPhoneNumberException.class, () -> userValidate.validatePhoneNumber("+573l92l925o5"));
    }

    @Test
    void throwExceptionWhenPhoneIsTooLong() {
        assertThrows(InvalidPhoneNumberException.class, () -> userValidate.validatePhoneNumber("+5731921925050"));
    }

    @Test
    void throwExceptionWhenPhoneIsNull() {
        assertThrows(IllegalArgumentException.class, () -> userValidate.validatePhoneNumber(null));
    }

    @Test
    void validateUserIsOlder() {
        UserModel userModel = new UserModel();
        userModel.setFechaNacimiento(Date.valueOf(LocalDate.now().minusYears(18)));
        assertDoesNotThrow(() -> userValidate.validateUserIsOlder(userModel));
    }

    @Test
    void throwExceptionWhenUserIsNotOlder() {
        UserModel userModel = new UserModel();
        userModel.setFechaNacimiento(Date.valueOf(LocalDate.now().minusYears(17)));
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateUserIsOlder(userModel));
    }

    @Test
    void throwExceptionWhenBirthDayIsNull() {
        UserModel userModel = new UserModel();
        userModel.setFechaNacimiento(null);
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateUserIsOlder(userModel));
    }

    @Test
    void validateEmail() {
        assertDoesNotThrow(() -> userValidate.validateEmail("correo@example.com"));
    }

    @Test
    void throwExceptionWhenEmailIsInvalid() {
        assertThrows(InvalidEmailException.class, () -> userValidate.validateEmail("correo@invalido"));
    }

    @Test
    void throwExceptionWhenEmailIsNull() {
        assertThrows(IllegalArgumentException.class, () -> userValidate.validateEmail(null));
    }
}