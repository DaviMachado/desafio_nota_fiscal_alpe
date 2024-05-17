package com.example.desafio_nota_fiscal_alpe.domain.vo;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteVO {
	
	@Size(min = 11, message = "O CPF tem que ser no minimo 11 caracteres")
	private String cpf;
	
}
