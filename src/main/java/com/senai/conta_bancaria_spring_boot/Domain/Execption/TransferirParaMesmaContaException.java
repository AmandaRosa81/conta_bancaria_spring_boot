package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class TransferirParaMesmaContaException extends RuntimeException {
    public TransferirParaMesmaContaException() {
        super("Não é possível transferir para a mesma conta.");
    }
}
