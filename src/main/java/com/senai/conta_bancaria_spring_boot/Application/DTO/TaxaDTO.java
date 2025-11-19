package com.senai.conta_bancaria_spring_boot.Application.DTO;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TaxaDTO(
        @NotBlank(message = "Descrição é obrigatória!")
        @Size(max = 100, message = "Descrição deve ter 100 caracteres")
        String descricao,

        @Digits(integer = 5, fraction = 2)
        BigDecimal percentual,

        @Digits(integer = 10, fraction = 2)
        BigDecimal valorFixo
) {
    @AssertTrue(message = "Digite apenas percentual ou valor fixo (nunca os dois!)")
    private boolean tipoTaxaValido(){
        return (percentual != null && valorFixo == null) ||
                (percentual == null && valorFixo != null);
    }
}
