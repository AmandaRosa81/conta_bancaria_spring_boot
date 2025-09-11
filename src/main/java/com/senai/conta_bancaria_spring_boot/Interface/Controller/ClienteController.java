package com.senai.conta_bancaria_spring_boot.Interface.Controller;

import com.senai.conta_bancaria_spring_boot.Application.Service.ClienteService;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
}
