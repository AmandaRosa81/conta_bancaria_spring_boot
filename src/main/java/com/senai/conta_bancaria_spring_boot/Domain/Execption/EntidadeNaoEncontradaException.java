package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String entidade) {
        super(entidade + "não existe ou inativo(a)!");
    }
}
