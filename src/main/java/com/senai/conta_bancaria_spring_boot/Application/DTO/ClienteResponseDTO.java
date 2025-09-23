package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;

import java.util.List;

public record ClienteResponseDTO (

        String nome,
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
