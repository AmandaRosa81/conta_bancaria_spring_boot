package com.senai.conta_bancaria_spring_boot.Domain.Repository;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.ContaPoupanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPoupancaRepository  extends JpaRepository<ContaPoupanca, String> {
}
