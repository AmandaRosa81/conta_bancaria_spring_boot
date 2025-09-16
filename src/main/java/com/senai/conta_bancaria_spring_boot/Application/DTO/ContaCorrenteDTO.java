package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaCorrente;

import java.math.BigDecimal;

public record ContaCorrenteDTO(
    BigDecimal limite,
    BigDecimal taxa
){
    public static ContaCorrenteDTO fromEntity(ContaCorrente contaCorrente){
        if(contaCorrente == null) return null;
        return new ContaCorrenteDTO(
                contaCorrente.getLimite(),
                contaCorrente.getTaxa()
        );
    }

    public ContaCorrente toEntity (){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setLimite(this.limite);
        contaCorrente.setTaxa(this.taxa);

        return contaCorrente;
    }
}
