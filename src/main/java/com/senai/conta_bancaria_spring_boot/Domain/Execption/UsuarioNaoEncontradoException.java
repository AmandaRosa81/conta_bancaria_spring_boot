package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}
