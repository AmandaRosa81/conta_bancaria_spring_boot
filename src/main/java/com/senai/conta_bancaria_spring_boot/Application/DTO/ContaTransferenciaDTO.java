package com.senai.conta_bancaria_spring_boot.Application.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContaTransferenciaDTO (
        @NotBlank(message = "Conta de destino não pode estar vazia")
        String contaDestino,
        @NotNull(message = "O valor é obrigatório")
        BigDecimal valor
){
}
