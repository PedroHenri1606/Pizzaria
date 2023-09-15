package com.piazzariap1.pizzaria.service.exception;

public class NaoLocalizadoException extends RuntimeException {

    public NaoLocalizadoException(String mensagem){
        super(mensagem);
    }
}
