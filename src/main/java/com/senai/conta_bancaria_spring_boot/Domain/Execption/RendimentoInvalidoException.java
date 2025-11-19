package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class RendimentoInvalidoException extends RuntimeException {
    public RendimentoInvalidoException() {
        super("O rendimento só deve ser aplicado em conta poupança!");
    }
}
