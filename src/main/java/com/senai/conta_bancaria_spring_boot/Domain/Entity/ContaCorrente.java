package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class ContaCorrente extends Conta{

    @Column(nullable = false, length = 100)
    private double limite;

    @NotNull(message = "O campo taxa da conta corrente, não pode estar vazio!")
    @Column(nullable = false, length = 100)
    private double taxa;


}
