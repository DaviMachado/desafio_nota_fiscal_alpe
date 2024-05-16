package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.repository.NotalFiscalRepository;
import com.example.desafio_nota_fiscal_alpe.utils.NotaFiscalUtils;

@Service
public class NotaFiscalServiceImpl implements INotaFiscalService {
	
	@Autowired
	private NotalFiscalRepository notalFiscalRepository;
	@Autowired
	private NotaFiscalUtils notaFiscalUtils;

	@Override
	public void salvarNotaFiscal(NotaFiscalVO notaFiscal) {
		notalFiscalRepository.save(notaFiscalUtils.voToEntity(notaFiscal));
	}

	@Override
	public String listarNotasFiscais() {
		// TODO Auto-generated method stub
		return null;
	}

}
