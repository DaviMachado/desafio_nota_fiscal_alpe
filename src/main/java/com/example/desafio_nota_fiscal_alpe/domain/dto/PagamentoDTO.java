package com.example.desafio_nota_fiscal_alpe.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagamentoDTO {

	private Integer numero;
    private String descricao;
    private BigDecimal valor;
	
}
