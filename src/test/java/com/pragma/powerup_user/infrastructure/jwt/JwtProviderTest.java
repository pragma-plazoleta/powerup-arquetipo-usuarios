package com.pragma.powerup_user.infrastructure.jwt;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class JwtProviderTest {

    private JwtProvider jwtProvider;
    private final String secret = "ThisIsASecretKeyForJwtTestingMustBeLongEnough12345";

    @BeforeEach
    void setUp() {
        jwtProvider = new JwtProvider();
        ReflectionTestUtils.setField(jwtProvider, "secret", secret);
    }

    @Test
    void generateAndValidateToken() {
        String token = jwtProvider.generateToken("testUser", 1L, "12345689");
        assertNotNull(token);
        assertTrue(jwtProvider.validateToken(token));
    }

    @Test
    void invalidateTokenValidation() {
        String invalidToken = "invalid.token.test";
        assertFalse(jwtProvider.validateToken(invalidToken));
    }

    @Test
    void getClaims() {
        String token = jwtProvider.generateToken("testUser", 2L, "987654321");
        Claims claims = jwtProvider.getClaims(token);
        assertEquals("987654321", claims.getSubject());
        assertEquals("testUser", claims.get("user"));
        assertEquals(2, claims.get("rol"));
    }

    @Test
    void getRolFromToken() {
        String token = jwtProvider.generateToken("testUser", 3L, "555555555");
        String bearerToken = "Bearer " + token;
        Integer rol = jwtProvider.getRolFromToken(bearerToken);
        assertEquals(3, rol);
    }
}