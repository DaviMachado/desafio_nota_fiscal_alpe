package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalInvalidaException;
import com.example.desafio_nota_fiscal_alpe.service.producer.CobrancaServiceProcuder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CobrancaService {
	
	@Autowired 
    private CobrancaServiceProcuder cobrancaServiceProcuder;

	public void enviar(NotaFiscalEntity notaFiscal) {
		try {
			cobrancaServiceProcuder.sendMessage(notaFiscal);
		} catch (Exception e) {
			log.error("Erro ao enviar a Nota Fiscal ao MS de Cobrança !!");
			throw new NotaFiscalInvalidaException("Erro ao enviar a Nota Fiscal ao MS de Cobrança !!", HttpStatus.BAD_REQUEST);
		}
	}
	
}
