package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Application.DTO.ContaAtualizacaoDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ContaResumoDTO;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Conta;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaCorrente;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaPoupanca;
import com.senai.conta_bancaria_spring_boot.Domain.Repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;

    @Transactional(readOnly = true)
    public List<ContaResumoDTO> listarContasAtivas(){
        return repository.findAllByAtivaTrue().stream().map(ContaResumoDTO::fromEntity).toList();
    }

    @Transactional(readOnly = true)
    public ContaResumoDTO buscarContaPorNumero(String numero) {
        return ContaResumoDTO.fromEntity(
                repository.findByNumeroAndAtivaTrue(numero)
                        .orElseThrow(() -> new RuntimeException("Conta não encontrada ou inativada."))
        );
    }

    public ContaResumoDTO atualizarConta(String numero, ContaAtualizacaoDTO dto) {
        Conta conta = repository.findByNumeroAndAtivaTrue(numero).orElseThrow(
                () -> new RuntimeException("Conta não encontrada ou já inativada.")

        );

        if (conta instanceof ContaPoupanca poupanca){
            poupanca.setRendimento(dto.rendimento());
        }else if (conta instanceof ContaCorrente corrente){
            corrente.setLimite(dto.limite());
            corrente.setTaxa(dto.taxa());
        }else{
            throw new RuntimeException("Tipo de conta inválido.");
        }
        conta.setSaldo(dto.saldo());

        return ContaResumoDTO.fromEntity(repository.save(conta));
    }


    public void inativarConta(String numeroConta) {
        Conta conta = repository.findByNumeroAndAtivaTrue(numeroConta).orElseThrow(
                () -> new RuntimeException("Conta não encontrada ou já inativada.")
        );
        conta.setAtiva(false);
        repository.save(conta);
    }
}
