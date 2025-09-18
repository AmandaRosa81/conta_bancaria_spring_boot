package com.senai.conta_bancaria_spring_boot.Interface_ui;

import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteRegistroDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteResponseDTO;
import com.senai.conta_bancaria_spring_boot.Application.Service.ClienteService;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor //Ele cria um construtor inicial, sem precisar que façamos
public class ClienteController {

    //Final: respresenta que as informações dessa classe não serão alterados
    private final ClienteService service;

    @PostMapping
    public ClienteResponseDTO registrarCliente(@RequestBody ClienteRegistroDTO dto){
        return service.registrarCliente(dto);
    }
}
