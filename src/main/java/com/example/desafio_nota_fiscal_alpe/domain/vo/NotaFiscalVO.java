package com.example.desafio_nota_fiscal_alpe.domain.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotaFiscalVO {

	@NotBlank
	private String texto;
	
}
