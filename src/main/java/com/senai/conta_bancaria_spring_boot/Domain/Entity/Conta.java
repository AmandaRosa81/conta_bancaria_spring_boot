package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import com.senai.conta_bancaria_spring_boot.Domain.Execption.SaldoInsuficienteException;
import com.senai.conta_bancaria_spring_boot.Domain.Execption.TransferirParaMesmaContaException;
import com.senai.conta_bancaria_spring_boot.Domain.Execption.ValoresNegativosExecption;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//Estratégia
@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING, length = 20)
@Table (name = "contaDTO",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_conta_numero", columnNames = "numero"),
                @UniqueConstraint(name = "uk_cliente_tipo", columnNames = {"cliente_id", "tipo_conta"})
        }
)
@SuperBuilder
@NoArgsConstructor

public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull(message = "O campo número da contaDTO não pode estar vazio!")
    @Column(nullable = false, length = 20)
    private String numero;

    @Column(nullable = false, precision = 4)
    private BigDecimal saldo;

    @Column(nullable = false)
    private boolean ativa;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_conta_cliente"))
    private Cliente cliente;

    public abstract String getTipo();

    public void sacar(BigDecimal valor){
        validarValorMaiorQueZero(valor, "sacar");
        if (valor.compareTo(saldo)>0){
            throw new SaldoInsuficienteException("Saque");
        }
        saldo = saldo.subtract(valor);
    }

    public void depositar(BigDecimal valor) {
        validarValorMaiorQueZero(valor, "dépositar");
        saldo = saldo.add(valor);
    }

    protected static void validarValorMaiorQueZero(BigDecimal valor, String operacao) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValoresNegativosExecption(operacao);
        }
    }

    public void transferir (BigDecimal valor, Conta contaDestino){
        if (this.id.equals(contaDestino.getId())){
            throw new TransferirParaMesmaContaException();
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

}

