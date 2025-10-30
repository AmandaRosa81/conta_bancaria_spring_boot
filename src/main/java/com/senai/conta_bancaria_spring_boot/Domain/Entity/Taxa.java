package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Taxa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String descricao;

    private BigDecimal percentual;

    private String valorFixo;

    private Set<Pagamento> pagamentos = new HashSet<>();
}
