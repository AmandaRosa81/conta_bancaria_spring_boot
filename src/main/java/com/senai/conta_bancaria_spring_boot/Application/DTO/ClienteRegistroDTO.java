package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record ClienteRegistroDTO(
        @NotBlank(message = "O campo nome do cliente não pode estar vazio!")
        String nome,
        @NotNull(message = "O campo cpf do cliente não pode estar vazio")
        String cpf,
        @Valid
        @NotNull
        ContaResumoDTO contaDTO
){
    public Cliente toEntity(){
        return Cliente.builder()
                .ativo(true)
                .nome(this.nome)
                .cpf(this.cpf)
                .contas(new ArrayList<Conta>())
                .build();
    }
}



