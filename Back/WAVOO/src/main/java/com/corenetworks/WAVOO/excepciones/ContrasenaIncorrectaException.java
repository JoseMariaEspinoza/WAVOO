package com.corenetworks.WAVOO.excepciones;

public class ContrasenaIncorrectaException extends RuntimeException {
    public ContrasenaIncorrectaException(String mensaje) {
        super(mensaje);
    }
}