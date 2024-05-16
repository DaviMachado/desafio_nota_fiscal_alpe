package com.example.desafio_nota_fiscal_alpe.exception;

import org.springframework.http.HttpStatus;

public class NotaFiscalInvalidaException extends RuntimeException {
    private final HttpStatus status;

    public NotaFiscalInvalidaException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
