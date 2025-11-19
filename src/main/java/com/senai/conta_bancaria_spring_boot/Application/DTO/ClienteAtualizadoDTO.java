package com.senai.conta_bancaria_spring_boot.Application.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record ClienteAtualizadoDTO (
        @Schema(description = "Nome do cliente atualizado", examples = "Ex: Bianca")
        @NotBlank(message = "O campo nome não pode estar vazio!")
        String nome,

        @Schema(description = "CPF do cliente atualizado", examples = "Ex: 12345678910")
        @NotBlank(message = "O campo cpf não pode estar vazio!")
        String cpf
){
}
