package com.pragma.powerup_user.domain.exception;

public class InvalidDocumentNumberException extends RuntimeException {
    public InvalidDocumentNumberException(String message) {
        super(message);
    }
}
