package com.example.desafio_nota_fiscal_alpe.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotaFiscalVO {

	private Long numero;
	
	private String formaPagamento;
	
	private ClienteVO cliente;
	
}
