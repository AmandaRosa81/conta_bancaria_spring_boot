package com.senai.conta_bancaria_spring_boot.Application.DTO;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ValorSaqueDepositoDTO (
        @NotNull (message = "O valor é obrigatório")
        BigDecimal valor
){
}
