package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class PagamentoNaoPendenteException extends RuntimeException {
    public PagamentoNaoPendenteException(String message) {
        super("Nenhum pagamento pendente!");
    }
}
