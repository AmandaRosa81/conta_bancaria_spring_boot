package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class PagamentoInvalidoException extends RuntimeException {
    public PagamentoInvalidoException() {
        super("Pagamento Inválido!");
    }
}
