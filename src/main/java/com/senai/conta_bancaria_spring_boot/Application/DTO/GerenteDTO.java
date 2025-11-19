package com.senai.conta_bancaria_spring_boot.Application.DTO;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Gerente;
import com.senai.conta_bancaria_spring_boot.Domain.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record GerenteDTO(
    @Schema(description = "ID do gerente", examples = "1")
    String id,

    @Schema(description = "Nome do gerente", examples = "Ex: Amanda")
    @NotBlank(message = "O campo nome do gerente não pode estar vazio!")
    String nome,

    @Schema(description = "CPF do gerente", examples = "Ex: 56734179210")
    @NotBlank(message = "O campo CPF do gerente não pode estar vazio!")
    String cpf,

    @Schema(description = "Email do gerente", examples = "Ex: gerente@gmail.com")
    @NotBlank(message = "O campo email do gerente não pode estar vazio!")
    String email,

    @Schema(description = "Senha do gerente", examples = "Ex: 20487193@A")
    @NotBlank(message = "O campo senha do gerente não pode estar vazio!")
    String senha,

    Boolean ativo,
    Role role
){
    public static GerenteDTO fromEntity(Gerente gerente) {
        return GerenteDTO.builder()
                .id(gerente.getId())
                .nome(gerente.getNome())
                .cpf(gerente.getCpf())
                .email(gerente.getEmail())
                .ativo(gerente.isAtivo())
                .role(gerente.getRole())
                .build();
    }

    public Gerente toEntity() {
        return Gerente.builder()
                .id(this.id)
                .nome(this.nome)
                .cpf(this.cpf)
                .email(this.email)
                .senha(this.senha)
                .ativo(this.ativo != null ? this.ativo : true)
                .role(this.role != null ? this.role : Role.GERENTE)
                .build();
    }
}
