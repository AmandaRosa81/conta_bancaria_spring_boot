package com.senai.conta_bancaria_spring_boot.Application.DTO;

import java.util.List;

public record ClienteResponseDTO (
        String id,
        String nome,
        String cpf,
        List<ContaResumoDTO> contas
){
}
