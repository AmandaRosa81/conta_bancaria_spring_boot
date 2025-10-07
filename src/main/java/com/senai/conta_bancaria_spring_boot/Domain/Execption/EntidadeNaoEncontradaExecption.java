package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class EntidadeNaoEncontradaExecption extends RuntimeException {
    public EntidadeNaoEncontradaExecption(String entidade) {
        super(entidade + "não existe ou inativo(a)!");
    }
}
