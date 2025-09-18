package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteRegistroDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteResponseDTO;
import com.senai.conta_bancaria_spring_boot.Domain.Repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponseDTO registrarCliente(ClienteRegistroDTO dto){

        var cliente = repository.findByCpfAndAtivoTrue(dto.cpf()).orElseGet( //orElseget, ele vai ver se tem o cpf,
                // se não for achado por ele a gente vai achar pelo ativo da contaDTO
                () -> repository.save(dto.toEntity())
        );

        var contas = cliente.getContas();
        var novaConta = dto.contaDTO().toEntity(cliente);

        boolean jaTemTipo = contas.stream().anyMatch(conta -> conta.getClass().equals(dto.contaDTO().getClass()) && conta.isAtiva());

        return
    }
}
