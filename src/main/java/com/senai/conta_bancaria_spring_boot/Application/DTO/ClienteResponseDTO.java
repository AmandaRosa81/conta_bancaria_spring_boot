package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClienteResponseDTO (
        @Schema(description = "Nome do cliente", examples = "Ex: Jamily")
        @NotBlank(message = "O nome não pode estar vazio!")
        String nome,

        @Schema(description = "CPF do cliente", examples = "Ex: 42391072568")
        @NotBlank(message = "O cpf não pode estar vazio!")
        String cpf,

        @Schema(description = "ID do cliente", examples = "2")
        String id,
        List<ContaResumoDTO> contas
){
    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        List<ContaResumoDTO> contas = cliente.getContas().stream().map(ContaResumoDTO::fromEntity).toList();
        return new ClienteResponseDTO(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getId(),
                contas
        );
    }
}
