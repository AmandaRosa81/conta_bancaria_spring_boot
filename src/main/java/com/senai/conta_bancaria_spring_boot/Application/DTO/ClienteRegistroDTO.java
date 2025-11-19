package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import com.senai.conta_bancaria_spring_boot.Domain.enums.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record ClienteRegistroDTO(
        @NotBlank(message = "O campo nome do cliente não pode estar vazio!")
        String nome,
        @NotBlank(message = "O campo cpf do cliente não pode estar vazio!")
        String cpf,
        @NotBlank(message = "O campo senha do cliente não pode estar vazio!")
        String senha,
        @NotBlank(message = "O campo email do cliente não pode estar vazio!")
        String email,
        Role role,
        @Valid
        @NotNull
        ContaResumoDTO contaDTO
){
    public Cliente toEntity(){
        return Cliente.builder()
                .ativo(true)
                .nome(this.nome)
                .cpf(this.cpf)
                .senha(this.senha)
                .email(this.email)
                .role(Role.CLIENTE)
                .contas(new ArrayList<Conta>())
                .build();
    }
}



