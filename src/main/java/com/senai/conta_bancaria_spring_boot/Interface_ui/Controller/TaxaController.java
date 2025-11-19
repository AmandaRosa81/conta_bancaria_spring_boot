package com.senai.conta_bancaria_spring_boot.Interface_ui.Controller;

import com.senai.conta_bancaria_spring_boot.Application.DTO.TaxaDTO;
import com.senai.conta_bancaria_spring_boot.Application.Service.TaxaService;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Taxa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxas")
@RequiredArgsConstructor
public class TaxaController {

    private final TaxaService taxaService;

    @PostMapping
    public ResponseEntity<Taxa> criar(@RequestBody TaxaDTO dto) {
        return ResponseEntity.ok(taxaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Taxa>> findAll() {
        return ResponseEntity.ok(taxaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taxa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taxaService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taxaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
