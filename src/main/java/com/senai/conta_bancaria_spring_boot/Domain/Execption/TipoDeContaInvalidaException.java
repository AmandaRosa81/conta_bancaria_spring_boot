package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class TipoDeContaInvalidaException extends RuntimeException {
    public TipoDeContaInvalidaException(String tipo) {
        super("Tipo de conta "+ tipo +" inválida. Os tipos válidos são: 'CORRENTE', 'POUPANCA'.");
    }
}
