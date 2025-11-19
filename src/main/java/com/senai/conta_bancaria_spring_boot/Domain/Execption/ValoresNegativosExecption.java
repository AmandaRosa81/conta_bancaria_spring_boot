package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class ValoresNegativosExecption extends RuntimeException {
    public ValoresNegativosExecption(String operacao) {
        super("Não é possível " + operacao + " valores negativos ou zero!");
    }
}
