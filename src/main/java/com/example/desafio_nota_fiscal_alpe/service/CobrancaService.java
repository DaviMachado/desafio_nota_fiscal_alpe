package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalInvalidaException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CobrancaService {

	public void enviar(NotaFiscalEntity notaFiscal) {
		try {
			//
			// simula a requisição para chamar o MS de Cobrança
			//
			log.info("Nota Fiscal enviada para o MS de Cobrança com sucesso !!");
		} catch (Exception e) {
			new NotaFiscalInvalidaException("Erro ao enviar a Nota Fiscal ao MS de Cobrança !!", HttpStatus.BAD_REQUEST);
			log.error("Erro ao enviar a Nota Fiscal ao MS de Cobrança !!");
		}
	}
	
}
