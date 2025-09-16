package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "cliente",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "cpf")
        }
)

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "O campo nome do cliente não pode estar vazio!")
    @Column(nullable = false, length = 120)
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotNull(message = "O campo cpf do cliente não pode estar vazio")
    @Column(nullable = false, length = 11)
    private String cpf;

    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Conta> contas;

    @Column (nullable = false)
    private Boolean ativo;
}
