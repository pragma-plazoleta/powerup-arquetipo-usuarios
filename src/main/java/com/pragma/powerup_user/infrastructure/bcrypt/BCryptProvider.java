package com.pragma.powerup_user.infrastructure.bcrypt;

import com.pragma.powerup_user.domain.spi.IBCryptPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptProvider implements IBCryptPort {

    private static final PasswordEncoder psswrdEncoder = new BCryptPasswordEncoder();

    @Override
    public String encryptPsswrd(String clave) {
        return psswrdEncoder.encode(clave);
    }

    @Override
    public Boolean matchesPsswrd(String userPass, String passInBD) {
        return psswrdEncoder.matches(userPass, passInBD);
    }
}
