package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.repository.NotalFiscalRepository;
import com.example.desafio_nota_fiscal_alpe.utils.NotaFiscalUtils;

@Service
public class NotaFiscalServiceImpl implements INotaFiscalService {
	
	@Autowired
	private NotalFiscalRepository notalFiscalRepository;
//	@Autowired(required=true)
//	private NotaFiscalUtils notaFiscalUtils;
	

	@Override
	public NotaFiscalDTO salvarNotaFiscal(NotaFiscalVO notaFiscal) {
		NotaFiscalEntity novaNotaFiscal = notalFiscalRepository.save(voToEntity(notaFiscal));
		
		return entityToDto(novaNotaFiscal);
	}

	@Override
	public String listarNotasFiscais() {
		return "Nota fiscal !!!";
	}
	
	public NotaFiscalEntity voToEntity(NotaFiscalVO notaFiscalVo) {
		NotaFiscalEntity nota = new NotaFiscalEntity();
		nota.setTexto(notaFiscalVo.getTexto());
		
		return nota;
	}
	
	public NotaFiscalDTO entityToDto(NotaFiscalEntity notaFiscalEntity) {
		NotaFiscalDTO nota = new NotaFiscalDTO();
		nota.setId(notaFiscalEntity.getId());
		nota.setTexto(notaFiscalEntity.getTexto());
		
		return nota;
	}

}
