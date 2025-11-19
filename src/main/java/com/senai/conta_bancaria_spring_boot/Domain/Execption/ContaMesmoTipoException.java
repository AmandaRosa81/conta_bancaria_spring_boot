package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class ContaMesmoTipoException extends RuntimeException {
    public ContaMesmoTipoException() {
        super("Não é possível criar uma conta do mesmo tipo para o mesmo cliente!");
    }
}
