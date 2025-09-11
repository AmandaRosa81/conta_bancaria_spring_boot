package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;

public record ContaDTO (
        int numero,
        double saldo
){
    public static ContaDTO fromEntity(Conta conta) {
        if (conta == null) return null;
        return new ContaDTO(
                conta.getNumero(),
                conta.getSaldo()
        );
    }

    public Conta toEntity (){
        Conta conta = new Conta();
        conta.setNumero(this.numero);
        conta.setSaldo(this.saldo);

        return conta;
    }
}
