package com.senai.conta_bancaria_spring_boot.Interface_ui;

import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteAtualizadoDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteResponseDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ContaResumoDTO;
import com.senai.conta_bancaria_spring_boot.Application.Service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @GetMapping
    public ResponseEntity <List<ContaResumoDTO>> listarContasAtivas(){
        return ResponseEntity.ok(service.listarContasAtivas());
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ContaResumoDTO> buscarContaPorNumero(@PathVariable String numeroConta) {
        return ResponseEntity.ok(service.buscarContaPorNumero(numeroConta));
    }

    @PutMapping("/numeroConta")
    public ResponseEntity <ContaResumoDTO> atualizarConta(){

        return ResponseEntity.ok(service.atualizarConta());
    }
}
