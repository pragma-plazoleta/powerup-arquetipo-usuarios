package com.pragma.powerup_user.infrastructure.bcrypt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BCryptProviderTest {

    private BCryptProvider bCryptProvider;

    @BeforeEach
    void setUp() {
        bCryptProvider = new BCryptProvider();
    }

    @Test
    void encryptPsswrd() {
        String rawPass = "Contraseña";
        String passEncode = bCryptProvider.encryptPsswrd(rawPass);
        Assertions.assertNotNull(passEncode);
        Assertions.assertNotEquals(rawPass, passEncode);
        boolean match = bCryptProvider.matchesPsswrd(rawPass, passEncode);
        assertTrue(match);
    }
}