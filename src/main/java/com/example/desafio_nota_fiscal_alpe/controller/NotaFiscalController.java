package com.example.desafio_nota_fiscal_alpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.service.NotaFiscalServiceImpl;

import jakarta.validation.Valid;

@RestController
public class NotaFiscalController {
	
	@Autowired
	private NotaFiscalServiceImpl notaFiscalServiceImpl;
	
	@PostMapping("/salvar-nota-fiscal")
	@ResponseStatus(HttpStatus.CREATED)
    public void createNote(@RequestBody @Valid NotaFiscalVO notaFiscal) {
		notaFiscalServiceImpl.salvarNotaFiscal(notaFiscal);
    }

}
