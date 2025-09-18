package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaCorrente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaPoupanca;
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
                    .numero(numero)
                    .saldo(saldo)
                    .ativa(true)
                    .build();
        }else if ("POUPANCA".equalsIgnoreCase(tipo)){
            return ContaPoupanca.builder()
                    .cliente(cliente)
                    .numero(numero)
                    .saldo(saldo)
                    .ativa(true)
                    .build();
        }
        return  null;
    }

//    public Conta toEntity (){
//        Conta contaDTO = new Conta();
//        contaDTO.setNumero(this.numero);
//        contaDTO.setSaldo(this.saldo);
//
//        return contaDTO;
//    }
}
