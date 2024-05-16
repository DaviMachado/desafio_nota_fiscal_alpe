package com.example.desafio_nota_fiscal_alpe.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotaFiscalDTO {

	private Long id;
	private Long numero;
	private String formaPagamento;
	private String nomeCliente;
	
}
