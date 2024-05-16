package com.example.desafio_nota_fiscal_alpe.service;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;

public interface INotaFiscalService {

	void salvarNotaFiscal(NotaFiscalVO notaFiscal);
	
	String listarNotasFiscais();
	
}
