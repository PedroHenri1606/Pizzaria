package com.piazzariap1.pizzaria.test.exception;

public class CadastroNaoRealizadoException extends RuntimeException{

    public CadastroNaoRealizadoException(String mensagem){
        super(mensagem);
    }

}
