package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ContaPoupanca extends Conta{

    @Column(nullable = false, length = 100)
    private double rendimento;
}
