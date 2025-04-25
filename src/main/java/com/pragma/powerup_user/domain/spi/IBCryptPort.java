package com.pragma.powerup_user.domain.spi;

public interface IBCryptPort {

    String encryptPsswrd (String clave);

    Boolean matchesPsswrd (String userPass, String passInBD);
}
