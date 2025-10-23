package com.senai.conta_bancaria_spring_boot.Application.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContaTransferenciaDTO (
        @Schema(description = "Conta Destino para realizar a transferência", examples = "Ex: 143-7")
        @NotBlank(message = "Conta de destino não pode estar vazia")
        String contaDestino,

        @Schema(description = "Valor à ser transferido", examples = "EX: 450")
        @NotNull(message = "O valor é obrigatório")
        BigDecimal valor
){
}
