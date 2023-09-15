package com.piazzariap1.pizzaria.service.exception;

public class CadastroNaoRealizadoException extends RuntimeException{

    public CadastroNaoRealizadoException(String mensagem){
        super(mensagem);
    }
}
