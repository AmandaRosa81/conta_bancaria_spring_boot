package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaCorrente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaPoupanca;
import com.senai.conta_bancaria_spring_boot.Domain.Execption.TipoDeContaInvalidaException;
import org.aspectj.apache.bcel.generic.RET;

import java.math.BigDecimal;

public record ContaResumoDTO(
            String numero,
            String tipo,
            BigDecimal saldo
    ){
        public Conta toEntity (Cliente cliente){
            if ("CORRENTE".equalsIgnoreCase(tipo)){
                return ContaCorrente.builder()
                        .cliente(cliente)
                        .numero(this.numero)
                        .saldo(this.saldo)
                        .taxa(new BigDecimal("0.05"))
                        .limite(new BigDecimal("500.0"))
                        .ativa(true)
                        .build();
            }else if ("POUPANCA".equalsIgnoreCase(tipo)){
                return ContaPoupanca.builder()
                        .cliente(cliente)
                        .numero(this.numero)
                        .saldo(this.saldo)
                        .rendimento(new BigDecimal("0.01"))
                        .ativa(true)
                        .build();
            }
            throw new TipoDeContaInvalidaException(tipo);
        }

        public static ContaResumoDTO fromEntity(Conta conta) {
            return new ContaResumoDTO(
                    conta.getId(),
                    conta.getTipo(),
                    conta.getSaldo()
            );
        }

//    public Conta toEntity (){
//        Conta contaDTO = new Conta();
//        contaDTO.setNumero(this.numero);
//        contaDTO.setSaldo(this.saldo);
//
//        return contaDTO;
//    }
}
