package com.example.desafio_nota_fiscal_alpe.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {

	private String message;
	private String status;
	
}
