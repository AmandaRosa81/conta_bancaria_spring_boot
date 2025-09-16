package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("poupanca")

public class ContaPoupanca extends Conta{

    @Column(precision = 5)
    private double rendimento;
}
