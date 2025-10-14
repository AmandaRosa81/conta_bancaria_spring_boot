package com.senai.conta_bancaria_spring_boot.Application.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ContaAtualizacaoDTO (
        @NotNull(message = "O saldo não pode ser nulo")
        @Positive(message = "O saldo não pode ser negativo")
        BigDecimal saldo,
        @NotNull(message = "O campo limite não pode ser nulo")
        BigDecimal limite,
        @NotNull(message = "O campo rendimento não pode ser nulo")
        BigDecimal rendimento,
        @NotNull(message = "O campo taxa não pode ser nulo")
        BigDecimal taxa
){
}
