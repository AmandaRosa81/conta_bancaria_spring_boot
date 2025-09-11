package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaPoupanca;

public record ContaPoupancaDTO (
        double rendimento
){
    public static ContaPoupancaDTO fromEntity(ContaPoupanca contaPoupanca) {
        if (contaPoupanca == null) return null;
        return new ContaPoupancaDTO(
                contaPoupanca.getRendimento()
        );
    }

    public ContaPoupanca toEntity() {
        ContaPoupanca contaPoupanca= new ContaPoupanca();
        contaPoupanca.setRendimento(this.rendimento);

        return contaPoupanca;
    }
}
