package com.senai.conta_bancaria_spring_boot.Domain.Repository;

import com.senai.conta_bancaria_spring_boot.Domain.Entity.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, String> {

}
