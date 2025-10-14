package com.senai.conta_bancaria_spring_boot.Application.DTO;

import jakarta.validation.constraints.NotBlank;

public record ClienteAtualizadoDTO (
        @NotBlank(message = "O campo nome não pode estar vazio!")
        String nome,
        @NotBlank(message = "O campo cpf não pode estar vazio!")
        String cpf
){
}
