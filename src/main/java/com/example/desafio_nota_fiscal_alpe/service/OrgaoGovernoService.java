package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalInvalidaException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrgaoGovernoService {

	public void validarNotaFiscal(NotaFiscalVO notaFiscal) {
		try {
			//
			// simula a requisição para validar a nota fiscal no orgão do governo
			//
			log.info("Nota Fiscal validada com sucesso no Orgão do Governo !!");
		} catch (Exception e) {
			new NotaFiscalInvalidaException("Nota Fiscal invalida no Orgão do Governo !!", HttpStatus.BAD_REQUEST);
			log.error("Nota Fiscal invalida no Orgão do Governo !!");
		}
	}
	
}
