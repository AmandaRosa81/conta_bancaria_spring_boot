package com.senai.conta_bancaria_spring_boot.Application.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ValorSaqueDepositoDTO (
        @Schema(description = "Valor do saque de deposito", examples = "Ex: 150")
        @NotNull (message = "O valor é obrigatório")
        BigDecimal valor
){
}
