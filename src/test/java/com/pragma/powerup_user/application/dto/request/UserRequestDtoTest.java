package com.pragma.powerup_user.application.dto.request;

import com.pragma.powerup_user.DummyMock;
import com.pragma.powerup_user.infrastructure.bcrypt.BCryptProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestDtoTest {

    private DummyMock dummyMock;

    @BeforeEach
    void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    void dtoGetterAndSetterTest() {
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setNombre(dummyMock.getSuccessUserRequestDto().getNombre());
        userRequestDto.setApellido(dummyMock.getSuccessUserRequestDto().getApellido());
        userRequestDto.setNumeroDocumento(dummyMock.getSuccessUserRequestDto().getNumeroDocumento());
        userRequestDto.setCelular(dummyMock.getSuccessUserRequestDto().getCelular());
        userRequestDto.setFechaNacimiento(dummyMock.getSuccessUserRequestDto().getFechaNacimiento());
        userRequestDto.setCorreo(dummyMock.getSuccessUserRequestDto().getCorreo());
        userRequestDto.setClave(dummyMock.getSuccessUserRequestDto().getClave());
        userRequestDto.setRol(dummyMock.getSuccessUserRequestDto().getRol());

        assertEquals(dummyMock.getSuccessUserRequestDto().getNombre(), userRequestDto.getNombre());
        assertEquals(dummyMock.getSuccessUserRequestDto().getApellido(), userRequestDto.getApellido());
        assertEquals(dummyMock.getSuccessUserRequestDto().getNumeroDocumento(), userRequestDto.getNumeroDocumento());
        assertEquals(dummyMock.getSuccessUserRequestDto().getCelular(), userRequestDto.getCelular());
        assertEquals(dummyMock.getSuccessUserRequestDto().getFechaNacimiento(), userRequestDto.getFechaNacimiento());
        assertEquals(dummyMock.getSuccessUserRequestDto().getCorreo(), userRequestDto.getCorreo());
        assertEquals(dummyMock.getSuccessUserRequestDto().getClave(), userRequestDto.getClave());
        assertEquals(dummyMock.getSuccessUserRequestDto().getRol(), userRequestDto.getRol());


    }
}