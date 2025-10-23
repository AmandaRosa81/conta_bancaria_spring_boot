package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteRegistroDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.ClienteResponseDTO;
import com.senai.conta_bancaria_spring_boot.Application.DTO.GerenteDTO;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Gerente;
import com.senai.conta_bancaria_spring_boot.Domain.Repository.GerenteRepository;
import com.senai.conta_bancaria_spring_boot.Domain.UsuarioNaoEncontradoException;
import com.senai.conta_bancaria_spring_boot.Domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GerenteService {

    private final GerenteRepository gerenteRepository;

    private final PasswordEncoder encoder;

    public GerenteDTO registrarGerente(GerenteDTO dto) {

        var gerente = gerenteRepository.findByCpfAndAtivoTrue(dto.cpf()).orElseGet( //orElseget, ele vai ver se tem o cpf,
                // se não for achado por ele a gente vai achar pelo ativo da contaDTO
                () -> gerenteRepository.save(dto.toEntity())
        );
        return ClienteResponseDTO.fromEntity(gerenteRepository.save(gerente));
    }

    @PreAuthorize("hasAnyRole('ADMIN','GERENTE')")
    public List<GerenteDTO> listarTodosGerentes(){
        return gerenteRepository.findAll().stream()
                .map(GerenteDTO::fromEntity)
                .toList();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public GerenteDTO cadastrarGerente(GerenteDTO dto) {
        Gerente entity = dto.toEntity();
        entity.setSenha(encoder.encode(dto.senha()));
        entity.setRole(Role.GERENTE);
        gerenteRepository.save(entity);
        return GerenteDTO.fromEntity(entity);
    }
}
