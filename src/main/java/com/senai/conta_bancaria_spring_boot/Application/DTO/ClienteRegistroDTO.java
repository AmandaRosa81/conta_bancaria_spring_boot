package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;

import java.util.List;

public record ClienteRegistroDTO(
        String id,
        String nome,
        String cpf,
        List<Conta> contas
){
    public static ClienteRegistroDTO fromEntity(Cliente cliente){
        if(cliente == null) return null;
        return new ClienteRegistroDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getContas()
        );
    }

    public Cliente toEntity (Conta conta){
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setContas(this.contas);

        return cliente;
    }
}



