package com.senai.conta_bancaria_spring_boot.Domain.Execption;

import org.springframework.http.HttpStatus;

public class TaxaInvalidaException extends RuntimeException {
    public TaxaInvalidaException(String message) {
        super("Taxa inválida, erro ao processar!");
    }
}
