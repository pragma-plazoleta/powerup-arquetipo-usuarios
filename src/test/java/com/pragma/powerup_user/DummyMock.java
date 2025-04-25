package com.pragma.powerup_user;

import com.pragma.powerup_user.application.dto.request.UserRequestDto;
import com.pragma.powerup_user.domain.model.UserModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DummyMock {

    private UserRequestDto userRequestDto;
    private UserModel userModel;


    public UserRequestDto getSuccessUserRequestDto (){
        String nombre = "juan";
        String apellido = "ruiz";
        String numeroDocumento = "1019001001";
        String celular = "+573192192505";
        LocalDate localDate = LocalDate.of(1990, 2, 8);
        Date fechaNacimiento = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String correo = "juancruiz88@gmail.com";
        String clave = "Contraseña";
        String rol = "2";
        return new UserRequestDto(nombre, apellido, numeroDocumento, celular, fechaNacimiento, correo, clave, rol);
    }

    public UserModel getSuccessUserModel (){
        Long id = null;
        String nombre = "juan";
        String apellido = "ruiz";
        String numeroDocumento = "1019001001";
        String celular = "+573192192505";
        LocalDate localDate = LocalDate.of(1990, 2, 8);
        Date fechaNacimiento = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String correo = "juancruiz88@gmail.com";
        String clave = "Contraseña";
        Long rol = 2L;
        return new UserModel(id, nombre, apellido, numeroDocumento, celular, fechaNacimiento, correo, clave, rol);
    }

}
