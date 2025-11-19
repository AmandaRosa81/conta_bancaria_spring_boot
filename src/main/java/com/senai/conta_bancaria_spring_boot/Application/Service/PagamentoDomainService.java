package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Pagamento;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Taxa;
import com.senai.conta_bancaria_spring_boot.Domain.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class PagamentoDomainService {

    public BigDecimal calcularTaxas(Pagamento pagamento){
        BigDecimal totalTaxas = BigDecimal.ZERO;

        for (Taxa taxa : pagamento.getTaxas()){
            if (taxa.getValorFixo() != null){
                totalTaxas = totalTaxas.add(taxa.getValorFixo());
            }
            if (taxa.getPercentual() != null){
                totalTaxas = totalTaxas.add(pagamento.getValorPago().multiply(taxa.getPercentual()).divide(BigDecimal.valueOf(100)));
            }
        }
        return totalTaxas;
    }

    public void validarPagamento(Pagamento pagamento) throws IllegalArgumentException{
        if (pagamento.getStatus() != Status.FALHA){
            throw new IllegalArgumentException ("O pagamento não está pendente!");
        }

        if (pagamento.getValorPago().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero!");
        }

        if (pagamento.getTaxas().isEmpty()){
            throw new IllegalArgumentException("O pagamento deve ter pelo menos uma taxa associada.");
        }

        if (isBoletoVencido(pagamento.getDataPagamento())){
            throw new IllegalArgumentException("O boleto está vencido e não pode ser pago.");
        }
    }

    private boolean isBoletoVencido(String dataPagamento){
        LocalDate dataVencimento = LocalDate.parse(dataPagamento, DateTimeFormatter.ISO_DATE);
        return dataVencimento.isBefore(LocalDate.now());
    }

    public void processarPagamento(Pagamento pagamento){
        BigDecimal totalTaxas = calcularTaxas(pagamento);
        BigDecimal valorTotal = pagamento.getValorPago().add(totalTaxas);

        validarPagamento(pagamento);

        if (!pagamento.getConta().temSaldoSuficiente(valorTotal)){
            pagamento.setStatus(Status.SALDO_INSUFICIENTE);
            throw new IllegalArgumentException("Saldo insuficiente para realizar o pagamento!");
        }

        pagamento.getConta().depositar(valorTotal);

        pagamento.setStatus(Status.SUCESSO);
    }

}
