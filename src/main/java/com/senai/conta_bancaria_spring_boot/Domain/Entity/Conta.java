package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public abstract class Conta {

    @NotNull(message = "O campo número da conta não pode estar vazio!")
    @Column(nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.UUID)
    private int numero;

    @PositiveOrZero(message = "O saldo inicial não pode ser negativo!")
    @Column(nullable = false, length = 100)
    private double saldo;
}

