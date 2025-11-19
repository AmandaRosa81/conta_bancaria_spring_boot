package com.senai.conta_bancaria_spring_boot.Application.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ContaAtualizacaoDTO (
        @Schema(description = "Saldo da conta atualizada", examples = "EX: 3500")
        @NotNull(message = "O saldo não pode ser nulo")
        @Positive(message = "O saldo não pode ser negativo")
        BigDecimal saldo,

        @Schema(description = "Limite da conta atualizada", examples = "Ex: 8000")
        @NotNull(message = "O campo limite não pode ser nulo")
        BigDecimal limite,

        @Schema(description = "Rendimento da conta atualizada", examples = "Ex: 2%")
        @NotNull(message = "O campo rendimento não pode ser nulo")
        BigDecimal rendimento,

        @Schema(description = "Taxa da conta atualizada", examples = "EX: 5%")
        @NotNull(message = "O campo taxa não pode ser nulo")
        BigDecimal taxa
){
}
