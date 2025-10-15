package com.senai.conta_bancaria_spring_boot.Domain.Repository;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
