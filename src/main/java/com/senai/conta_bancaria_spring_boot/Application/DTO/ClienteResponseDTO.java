package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClienteResponseDTO (
        @NotBlank(message = "O nome não pode estar vazio!")
        String nome,
        @NotBlank(message = "O cpf não pode estar vazio!")
        String cpf,
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
