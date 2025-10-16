package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table (name = "cliente",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "cpf")
        }
)

public class Cliente extends Usuario{
    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Conta> contas;

    @Column (nullable = false)
    private Boolean ativo;
}
