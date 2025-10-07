package com.senai.conta_bancaria_spring_boot.Interface_ui.Execption;

import com.senai.conta_bancaria_spring_boot.Domain.Execption.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExecptionHandler {
    @ExceptionHandler(ValoresNegativosExecption.class)
    public ResponseEntity<String> handleValoresNegativos (ValoresNegativosExecption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<String> handleSaldoInsuficiente (SaldoInsuficienteException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.PAYMENT_REQUIRED);
    }

    @ExceptionHandler(TipoDeContaInvalidaException.class)
    public ResponseEntity<String> handleTipoDeContaInvalida (TipoDeContaInvalidaException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransferirParaMesmaContaException.class)
    public ResponseEntity<String> handleTransferirParaMesmaConta (TransferirParaMesmaContaException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RendimentoInvalidoException.class)
    public ResponseEntity<String> handleRendimentoInvalido (RendimentoInvalidoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntidadeNaoEncontradaExecption.class)
    public ResponseEntity<String> handleEntidadeNaoEncontrada (EntidadeNaoEncontradaExecption ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContaMesmoTipoException.class)
    public  ResponseEntity<String> handleContaMesmoTipo (ContaMesmoTipoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
