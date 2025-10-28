package com.senai.conta_bancaria_spring_boot.Application.Service;

import com.senai.conta_bancaria_spring_boot.Application.DTO.AuthDTO;
import com.senai.conta_bancaria_spring_boot.Domain.Entity.Usuario;
import com.senai.conta_bancaria_spring_boot.Domain.Repository.UsuarioRepository;
import com.senai.conta_bancaria_spring_boot.Domain.UsuarioNaoEncontradoException;
import com.senai.conta_bancaria_spring_boot.infrastructure.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarios;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public Map<String,String> login(AuthDTO.LoginRequest req) {
        Usuario usuario = usuarios.findByEmail(req.email())
                .orElseThrow(() ->  new UsuarioNaoEncontradoException("Usuário não encontrado"));

        if (!encoder.matches(req.senha(), usuario.getSenha())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        String accessToken = jwt.generateAccessToken(usuario.getEmail(), usuario.getRole().name());
        String refreshToken = jwt.generateRefreshToken(usuario.getEmail());

        return Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );
    }

    public Map<String, String> refresh(String refreshToken) {
        if (!jwt.isValid(refreshToken)) {
            throw new BadCredentialsException("Refresh token inválido ou expirado");
        }

        String email = jwt.extractEmail(refreshToken);
        Usuario usuario = usuarios.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        String newAccess = jwt.generateAccessToken(usuario.getEmail(), usuario.getRole().name());
        return Map.of("accessToken", newAccess);
    }
}
