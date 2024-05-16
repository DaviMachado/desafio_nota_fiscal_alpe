package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalInvalidaException;
import com.example.desafio_nota_fiscal_alpe.service.producer.OrgaoGovernoProcuder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrgaoGovernoService {
	
	@Autowired 
    private OrgaoGovernoProcuder orgaoGovernoProcuder;

	public void validarNotaFiscal(NotaFiscalVO notaFiscal) {
		try {
			orgaoGovernoProcuder.sendMessage(notaFiscal);
		} catch (Exception e) {
			log.error("Nota Fiscal invalida no Orgão do Governo !!");
			throw new NotaFiscalInvalidaException("Nota Fiscal invalida no Orgão do Governo !!", HttpStatus.BAD_REQUEST);
		}
	}
	
}
