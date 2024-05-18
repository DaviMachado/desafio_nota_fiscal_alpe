package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalInvalidaException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrgaoGovernoService {	
	
//	@Autowired
//	RestTemplate restTemplate;

	public void validarNotaFiscal(NotaFiscalVO notaFiscal) {
		try {
			//
			// Simula a chamada para o Orgão do Governo,
			// para validar a Nota Fiscal
			//
			
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			headers.set("Authorization", "Bearer " + "token");
//			
//			HttpEntity<NotaFiscalVO> request = new HttpEntity<>(notaFiscal, headers);
//			ResponseEntity<String> response = restTemplate
//					.exchange(
//								new URI("/orgao-governo"), 
//								HttpMethod.POST,
//								request, 
//								String.class
//							);
//
//			int status = response.getStatusCode().value();
			
			int status = 200;
			
			if (status == HttpStatus.OK.value()) {
				log.info("Nota Fiscal validada com Sucesso no Orgão do Governo !!");
			}
			else {
				log.error("Nota Fiscal invalida no Orgão do Governo !!");
				throw new NotaFiscalInvalidaException("Nota Fiscal invalida no Orgão do Governo !!", HttpStatus.BAD_REQUEST);
			} 
		} catch (Exception e) {
			log.error("Erro inesperado ao validar a Nota Fiscal no Orgão do Governo !!");
			throw new NotaFiscalInvalidaException("Erro inesperado ao validar a Nota Fiscal no Orgão do Governo !!", HttpStatus.BAD_REQUEST);
		}
	}
	
}
