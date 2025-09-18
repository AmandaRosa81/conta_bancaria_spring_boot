package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;

import java.util.ArrayList;
import java.util.List;

public record ClienteRegistroDTO(
        String nome,
        String cpf,
        boolean ativo,
        List<Conta> contaDTO
){
    public static ClienteRegistroDTO fromEntity(Cliente cliente){
        if(cliente == null) return null;
        return new ClienteRegistroDTO(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getAtivo(),
                cliente.getContas()
        );
    }

    public Cliente toEntity(){
        return Cliente.builder()
                .ativo(true)
                .nome(this.nome)
                .cpf(this.cpf)
                .contas(new ArrayList<Conta>())
                .build();
    }


//    public Cliente toEntity (Conta contaDTO){
//        Cliente cliente = new Cliente();
//        cliente.setNome(this.nome);
//        cliente.setCpf(this.cpf);
//        cliente.setContas(this.contas);
//
//        return cliente;
//    }
}



