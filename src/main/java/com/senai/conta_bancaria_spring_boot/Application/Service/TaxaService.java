package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Application.DTO.TaxaDTO;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Taxa;
import com.senai.conta_bancaria_spring_boot.Domain.Repository.TaxaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxaService {

    private final TaxaRepository taxaRepository;

    public Taxa create(TaxaDTO dto) {

        Taxa taxa = new Taxa();
        taxa.setDescricao(dto.descricao());
        taxa.setPercentual(dto.percentual());
        taxa.setValorFixo(dto.valorFixo());

        return taxaRepository.save(taxa);
    }

    public List<Taxa> listAll() {
        return taxaRepository.findAll();
    }

    public Taxa findById(String id) {
        return taxaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Taxa não encontrada"));
    }

    public void delete(String id) {
        taxaRepository.deleteById(id);
    }
}
