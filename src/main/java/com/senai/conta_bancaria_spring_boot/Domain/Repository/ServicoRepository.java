package com.senai.conta_bancaria_spring_boot.Domain.Repository;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
