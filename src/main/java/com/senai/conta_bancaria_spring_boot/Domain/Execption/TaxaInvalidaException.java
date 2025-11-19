package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class TaxaInvalidaException extends RuntimeException {
    public TaxaInvalidaException(String message) {
        super(message);
    }
}
