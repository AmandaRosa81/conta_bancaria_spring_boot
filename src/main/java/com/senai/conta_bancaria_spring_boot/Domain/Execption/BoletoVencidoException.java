package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class BoletoVencidoException extends RuntimeException {
    public BoletoVencidoException(String message) {
        super("Boleto vencido! Não há mais como pagar.");
    }
}
