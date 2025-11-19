package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Pagamento;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Taxa;
import com.senai.conta_bancaria_spring_boot.Domain.Repository.PagamentoRepository;
import com.senai.conta_bancaria_spring_boot.Domain.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PagamentoAppService {
    private final PagamentoDomainService pagamentoDomainService;
    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoAppService(PagamentoDomainService pagamentoDomainService, PagamentoRepository pagamentoRepository){
        this.pagamentoDomainService = pagamentoDomainService;
        this.pagamentoRepository = pagamentoRepository;
    }

    public void processarPagamento(Pagamento pagamento, Set<Taxa> taxas){
        pagamento.setTaxas(taxas);
        try{
            pagamentoDomainService.processarPagamento(pagamento);
        }catch (IllegalStateException | IllegalArgumentException e){
            pagamento.setStatus(Status.FALHA);
            pagamentoRepository.save(pagamento);
            throw new RuntimeException("Erro ao processar o pagamento: " + e.getMessage());
        }
        pagamentoRepository.save(pagamento);
    }
}
