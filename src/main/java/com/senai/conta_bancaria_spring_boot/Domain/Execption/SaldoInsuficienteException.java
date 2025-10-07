package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String operacao) {
        super("Saldo insuficiente para realizar a operação de " + operacao);
    }
}
