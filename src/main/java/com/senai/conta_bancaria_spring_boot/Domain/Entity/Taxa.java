package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Taxa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String descricao;

    private BigDecimal percentual;

    private BigDecimal valorFixo;

    @ManyToMany(mappedBy = "taxas")
    private Set<Pagamento> pagamentos = new HashSet<>();
}
