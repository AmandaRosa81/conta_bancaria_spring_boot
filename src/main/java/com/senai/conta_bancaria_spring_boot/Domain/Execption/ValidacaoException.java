package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}
