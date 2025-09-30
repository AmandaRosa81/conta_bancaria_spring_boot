package com.senai.conta_bancaria_spring_boot.Application.DTO;

import java.math.BigDecimal;

public record ContaTransferenciaDTO (
        String contaDestino,
        BigDecimal valor
){
}
