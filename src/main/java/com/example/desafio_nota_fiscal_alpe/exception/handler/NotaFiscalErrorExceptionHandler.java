package com.example.desafio_nota_fiscal_alpe.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.desafio_nota_fiscal_alpe.domain.dto.ErrorDTO;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalErrorException;

@ControllerAdvice
public class NotaFiscalErrorExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(NotaFiscalErrorException.class)
	public ErrorDTO handler(NotaFiscalErrorException ex) {
		return new ErrorDTO(
				ex.getMessage(),
				ex.getStatus().toString()
			);
	}
}
