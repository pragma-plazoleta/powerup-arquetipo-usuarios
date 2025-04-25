package com.pragma.powerup_user.domain.spi;

public interface ISecurityPort {

    String generateToken (String name, Long rol, String documentNumber);

    Integer getRolFromToken (String Token);

}
