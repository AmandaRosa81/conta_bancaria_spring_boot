package com.senai.conta_bancaria_spring_boot.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gerente")
public class Gerente extends Usuario{

}
