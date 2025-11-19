package com.senai.conta_bancaria_spring_boot.Application.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Set;

public record PagamentoDTO (
        @NotBlank(message = "O campo numero da conta não pode estar em branco!")
        @Schema(description = "Numero da conta para o pagamento", example = "1234-5")
        String contaNumero,

        @NotBlank(message = "O campo valor não pode estar em branco!")
        @Schema(description = "Valor pago no boleto", example = "300")
        BigDecimal valorPago,

        @NotBlank(message = "O campo data do pagamento não pode estar em branco!")
        @Schema(description = "Data do pagamento", example = "15//08/2025")
        String dataPagamento,

        @NotBlank(message = "O campo id não pode estar em branco!")
        @Schema(description = "IDs das taxas associadas ao pagamento", example = "3569721658942350379054")
        Set<String> taxas
) {
}
