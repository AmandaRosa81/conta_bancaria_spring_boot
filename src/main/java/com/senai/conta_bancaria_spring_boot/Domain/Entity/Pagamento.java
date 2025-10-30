package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "conta_número")
    private Conta conta;

    private String boleto;

    private BigDecimal valorPago;

    private String dataPagamento;

    private String status;

    @ManyToMany
    @JoinTable(
            name = "taxa_pagamento",
            joinColumns = @JoinColumn(name = "pagamento_id"),
            inverseJoinColumns = @JoinColumn(name = "taxa_id")
    )
    private Set<Taxa> taxas = new HashSet<>();
}
