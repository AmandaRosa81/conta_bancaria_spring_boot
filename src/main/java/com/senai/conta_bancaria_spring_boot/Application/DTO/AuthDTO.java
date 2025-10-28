package com.senai.conta_bancaria_spring_boot.Application.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthDTO {
    public record LoginRequest(
            @Schema(description = "Email de login", examples = "Ex: amanda@gmail.com")
            String email,

            @Schema(description = "Senha de login", examples = "Ex: 94327038M&")
            String senha
    ) {}

    public record TokenResponse(
            String token
    ) {}

    public record AuthResponse(
            String accessToken, String refreshToken
    ) {}

    public record RefreshRequest(
            String refreshToken
    ) {}

    public record UserResponse(
            String nome, String email, String role
    ) {}
}
