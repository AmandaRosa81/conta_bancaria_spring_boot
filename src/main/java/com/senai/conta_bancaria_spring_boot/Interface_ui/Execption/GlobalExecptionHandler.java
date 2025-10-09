package com.senai.conta_bancaria_spring_boot.Interface_ui.Execption;

import com.senai.conta_bancaria_spring_boot.Domain.Execption.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExecptionHandler {

    //ValoresNegativosExecption
    @ExceptionHandler(ValoresNegativosExecption.class)
    public ProblemDetail handleValoresNegativos (ValoresNegativosExecption ex, HttpServletRequest request) {
       return ProblemDetailUtils.buildProblem(
               HttpStatus.BAD_REQUEST,
               "Valores negativos não são permitidos.",
               ex.getMessage(),
               request.getRequestURI()
       );
    }

    //SaldoInsuficienteException
    @ExceptionHandler(SaldoInsuficienteException.class)
    public ProblemDetail handleSaldoInsuficiente (SaldoInsuficienteException ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.PAYMENT_REQUIRED,
                "Transação recusada por saldo insuficiente",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    //TipoDeContaInvalidaException
    @ExceptionHandler(TipoDeContaInvalidaException.class)
    public ProblemDetail handleTipoDeContaInvalida (TipoDeContaInvalidaException ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.BAD_REQUEST,
                "Conta com tipo inválido ou não reconhecido",
                ex.getMessage(),
                request.getRequestURI()
                );
    }

    //TransferirParaMesmaContaException
    @ExceptionHandler(TransferirParaMesmaContaException.class)
    public ProblemDetail handleTransferirParaMesmaConta (TransferirParaMesmaContaException ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.BAD_REQUEST,
                "Conta de origem e destino devem ser diferentes",
                ex.getMessage(),
                request.getRequestURI()
                );
    }

    //RendimentoInvalidoException
    @ExceptionHandler(RendimentoInvalidoException.class)
    public ProblemDetail handleRendimentoInvalido (RendimentoInvalidoException ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.BAD_REQUEST,
                "Rendimento informado é inválido ou inconsistente",
                ex.getMessage(),
                request.getRequestURI()
                );
    }

    //RendimentoInvalidoException
    @ExceptionHandler(EntidadeNaoEncontradaExecption.class)
    public ProblemDetail handleEntidadeNaoEncontrada (EntidadeNaoEncontradaExecption ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.NOT_FOUND,
                "Valor de rendimento não compatível com o tipo de operação",
                ex.getMessage(),
                request.getRequestURI()
                );
    }

    //ContaMesmoTipoException
    @ExceptionHandler(ContaMesmoTipoException.class)
    public ProblemDetail handleContaMesmoTipo (ContaMesmoTipoException ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.CONFLICT,
                "Transação não permitida entre contas do mesmo tipo",
                ex.getMessage(),
                request.getRequestURI()
                );
    }

    //Exception
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException (Exception ex, HttpServletRequest request){
        return ProblemDetailUtils.buildProblem(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro inesperado ao processar a solicitação",
                ex.getMessage(),
                request.getRequestURI()
                );
    }


    //MethodArgumentNotValidException
    // É lançada quando a validação de um argumento de metodo falha,
    // como quando um campo obrigatório é nulo ou não atende a outras anotações de validação.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail badRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetailUtils.buildProblem(
                HttpStatus.BAD_REQUEST,
                "Erro de validação",
                "Um ou mais campos são inválidos",
                request.getRequestURI()
        );

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        problem.setProperty("errors", errors);
        return problem;
    }


    //MethodArgumentTypeMismatchException
    //É uma exceção do Spring que ocorre quando o tipo de dado de um argumento enviado para um metodo,
    // não corresponde ao tipo esperado pelo metodo.
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ProblemDetail handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Tipo de parâmetro inválido");
        problem.setDetail(String.format(
                "O parâmetro '%s' deve ser do tipo '%s'. Valor recebido: '%s'",
                ex.getName(),
                ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconhecido",
                ex.getValue()
        ));
        problem.setInstance(URI.create(request.getRequestURI()));
        return problem;
    }


    //ConversionFailedException
    //Ele indica que uma tentativa de converter um valor de um tipo para outro falhou.
    @ExceptionHandler(ConversionFailedException.class)
    public ProblemDetail handleConversionFailed(ConversionFailedException ex, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Falha de conversão de parâmetro");
        problem.setDetail("Um parâmetro não pôde ser convertido para o tipo esperado.");
        problem.setInstance(URI.create(request.getRequestURI()));
        problem.setProperty("error", ex.getMessage());
        return problem;
    }


    //ConstraintViolationException
    //Para erros de validação,ou seja,que um objeto não atendeu às regras de restrição (constraints) definidas em sua classe.
    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Erro de validação nos parâmetros");
        problem.setDetail("Um ou mais parâmetros são inválidos");
        problem.setInstance(URI.create(request.getRequestURI()));

        Map<String, String> errors = new LinkedHashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String campo = violation.getPropertyPath().toString();
            String mensagem = violation.getMessage();
            errors.put(campo, mensagem);
        });
        problem.setProperty("errors", errors);
        return problem;
    }
}
