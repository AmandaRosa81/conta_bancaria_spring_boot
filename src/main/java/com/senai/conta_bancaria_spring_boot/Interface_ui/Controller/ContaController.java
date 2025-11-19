package com.senai.conta_bancaria_spring_boot.Interface_ui.Controller;

import com.senai.conta_bancaria_spring_boot.Application.DTO.*;
import com.senai.conta_bancaria_spring_boot.Application.Service.ContaService;
import jakarta.validation.Valid;
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
    public ResponseEntity <ContaResumoDTO> atualizarConta(@PathVariable String numeroConta,@Valid @RequestBody ContaAtualizacaoDTO dto){
        return ResponseEntity.ok(service.atualizarConta(numeroConta, dto));
    }

    @DeleteMapping("/{numeroConta}")
    public ResponseEntity<Void> inativarConta(@PathVariable String numeroConta) {
        service.inativarConta(numeroConta);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{numeroConta}/sacar")
    public ResponseEntity<ContaResumoDTO> sacar(@PathVariable String numeroConta,@Valid @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.sacar(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/depositar")
    public ResponseEntity<ContaResumoDTO> depositar(@PathVariable String numeroConta,@Valid @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.depositar(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/transferir")
    public ResponseEntity<ContaResumoDTO> transferir(@PathVariable String numeroConta,@Valid @RequestBody ContaTransferenciaDTO dto) {
        return ResponseEntity.ok (service.transferir(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/rendimento")
    public ResponseEntity<ContaResumoDTO> rendimento (@PathVariable String numeroDaConta){
        return ResponseEntity.ok(service.aplicarRendimento(numeroDaConta));
    }

}
