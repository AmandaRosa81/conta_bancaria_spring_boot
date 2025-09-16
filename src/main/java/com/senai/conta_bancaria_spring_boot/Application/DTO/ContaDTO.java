package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;

import java.math.BigDecimal;

public record ContaDTO (
        String id,
        String numero,
        BigDecimal saldo
){
    public static ContaDTO fromEntity(Conta conta) {
        if (conta == null) return null;
        return new ContaDTO(
                conta.getId(),
                conta.getNumero(),
                conta.getSaldo()
        );
    }

//    public Conta toEntity (){
//        Conta conta = new Conta();
//        conta.setNumero(this.numero);
//        conta.setSaldo(this.saldo);
//
//        return conta;
//    }
}
