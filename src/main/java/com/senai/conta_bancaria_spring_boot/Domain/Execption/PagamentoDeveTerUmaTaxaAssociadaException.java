package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class PagamentoDeveTerUmaTaxaAssociadaException extends RuntimeException {
    public PagamentoDeveTerUmaTaxaAssociadaException(String message) {
        super("Para ser feito o pagamento, deve haver ao menos uma taxa associada!");
    }
}
