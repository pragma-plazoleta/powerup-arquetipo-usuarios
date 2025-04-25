package com.pragma.powerup_user.domain.util;

public class Constans {

    public static final String USER_IS_NOT_OLDER = "El usuario debe ser mayor de edad";
    public static final String INVALID_DOCUMENT = "El campo número de documento solo acepta caracteres numericos";
    public static final String NULL_OR_EMPTY = "Informacion nula o vacia";
    public static final String INVALID_PHONE_NUMBER = "El número de teléfono no puede tener más de 13 caracteres";
    public static final String INVALID_EMAIL = "El correo ingresado no es valido";
    public static final String AUTHORIZATION_HEADER = "Authorization";


    public static final int ROL_ADMINISTRADOR = 1;
    public static final int ROL_PROPIETARIO = 2;
    public static final int MAX_LENGTH_PHONE = 13;
    public static final int MIN_YEARS_OLD = 18;
    public static final int EXPIRATION_TIME_JWT = 3600000;


    public static final String ONLY_NUMBERS = "^\\d+$";
    public static final String VALIDATE_PHONE_NUMBER = "^\\+?\\d{1,12}$";
    public static final String VALIDATE_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";




}
