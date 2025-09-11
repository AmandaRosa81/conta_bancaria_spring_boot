package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
public class Cliente {

    @NotBlank(message = "O campo nome do cliente não pode estar vazio!")
    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotNull(message = "O campo cpf do cliente não pode estar vazio")
    @Column(nullable = false, length = 5)
    private int cpf;

    @ElementCollection
    @CollectionTable(name = "cliente_contas",
            joinColumns = @JoinColumn(name = "conta_cliente"))
    @Column(name = "contas")
    private List<String> contas;

}
