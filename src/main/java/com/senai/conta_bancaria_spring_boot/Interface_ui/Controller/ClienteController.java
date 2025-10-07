package com.senai.conta_bancaria_spring_boot.Interface_ui.Controller;

import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteAtualizadoDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteRegistroDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteResponseDTO;
import com.senai.conta_bancaria_spring_boot.Application.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor //Ele cria um construtor inicial, sem precisar que façamos
public class ClienteController {

    //Final: respresenta que as informações dessa classe não serão alterados
    private final ClienteService service;

    @PostMapping
    public ResponseEntity <ClienteResponseDTO> registrarCliente(@RequestBody ClienteRegistroDTO dto){
        ClienteResponseDTO novoCliente = service.registrarCliente(dto);

        return ResponseEntity.created(URI.create("/api/cliente/cpf/" +
                novoCliente.cpf())).body(novoCliente);
    }

    @GetMapping
    public  ResponseEntity <List<ClienteResponseDTO>> listarClientesAtivos(){
        return ResponseEntity.ok(service.listarClientesAtivos());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteResponseDTO> buscarClienteAtivoPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(service.buscarClienteAtivoPorCpf(cpf));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity <ClienteResponseDTO> atualizarCliente(@PathVariable String cpf , @RequestBody ClienteAtualizadoDTO dto){

        return ResponseEntity.ok(service.atualizarCliente(cpf, dto));
    }
    @DeleteMapping("/cpf/{cpf}")
    public ResponseEntity<Void> deletarCliente (@PathVariable String cpf){
        service.deletarCliente(cpf);
        return ResponseEntity.noContent().build();
    }

}
