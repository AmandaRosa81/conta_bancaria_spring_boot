package com.senai.conta_bancaria_spring_boot.Domain.Execption;

public class TaxaNaoEncontradaException extends RuntimeException {
  public TaxaNaoEncontradaException(String taxaId) {
    super("Taxa não encontrada: " + taxaId);
  }
}
