package com.pragma.powerup_user.domain.validate;

import com.pragma.powerup_user.domain.exception.InvalidDocumentNumberException;
import com.pragma.powerup_user.domain.exception.InvalidEmailException;
import com.pragma.powerup_user.domain.exception.InvalidPhoneNumberException;
import com.pragma.powerup_user.domain.model.UserModel;
import com.pragma.powerup_user.domain.util.Constans;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@Component
public class UserValidate {

    public void validateDataNotNull (UserModel userModel) {
        if (userModel.getNombre() == null || userModel.getNombre().isBlank()){
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }

        if (userModel.getApellido() == null || userModel.getApellido().isBlank()){
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }

        if (userModel.getClave() == null || userModel.getClave().isBlank()){
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }

        if (userModel.getRol() == null){
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }
    }

    public void validateDocumentNumber (String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank() || !documentNumber.matches(Constans.ONLY_NUMBERS)){
            throw new InvalidDocumentNumberException(Constans.INVALID_DOCUMENT);
        }
    }

    public void validatePhoneNumber (String phone) {
        if (phone == null || phone.isBlank()){
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }
        if (phone.length() > Constans.MAX_LENGTH_PHONE || !phone.matches(Constans.VALIDATE_PHONE_NUMBER)){
            throw new InvalidPhoneNumberException(Constans.INVALID_PHONE_NUMBER);
        }
    }

    public void validateUserIsOlder (UserModel userModel){
        if (userModel.getFechaNacimiento() != null ){
            LocalDate localBirthDate = Instant.ofEpochMilli(userModel.getFechaNacimiento().getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            LocalDate today = LocalDate.now();

            if (Period.between(localBirthDate, today).getYears() < Constans.MIN_YEARS_OLD) {
                throw new IllegalArgumentException(Constans.USER_IS_NOT_OLDER);
            }
        } else {
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }
    }

    public void validateEmail (String email) {
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException(Constans.NULL_OR_EMPTY);
        }
        if (!email.matches(Constans.VALIDATE_EMAIL)) {
            throw new InvalidEmailException(Constans.INVALID_EMAIL);
        }
    }

}
