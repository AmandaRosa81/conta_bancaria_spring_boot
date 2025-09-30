package com.senai.conta_bancaria_spring_boot.Interface_ui;

import com.senai.conta_bancaria_spring_boot.Application.DTO.*;
import com.senai.conta_bancaria_spring_boot.Application.Service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
    public ResponseEntity <ContaResumoDTO> atualizarConta(@PathVariable String numeroConta, @RequestBody ContaAtualizacaoDTO dto){
        return ResponseEntity.ok(service.atualizarConta(numeroConta, dto));
    }

    @DeleteMapping("/{numeroConta}")
    public ResponseEntity<Void> inativarConta(@PathVariable String numeroConta) {
        service.inativarConta(numeroConta);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{numeroConta}/sacar")
    public ResponseEntity<ContaResumoDTO> sacar(@PathVariable String numeroConta, @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.sacar(numeroConta, dto));
    }

    @PutMapping("/{numeroConta}/depositar")
    public ResponseEntity<ContaResumoDTO> depositar(@PathVariable String numeroConta, @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.depositar(numeroConta, dto));
    }

    @PutMapping("/{numeroConta}/transferir")
    public ResponseEntity<ContaResumoDTO> transferir(@PathVariable String numeroConta,
                                           @RequestBody ContaTransferenciaDTO dto) {
        return ResponseEntity.ok (service.transferir(numeroConta, dto));
    }

}
