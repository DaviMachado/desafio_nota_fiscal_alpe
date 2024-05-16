package com.example.desafio_nota_fiscal_alpe.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.entity.ClienteEntity;
import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;

@Component
public class NotaFiscalUtils {

	public NotaFiscalEntity voToEntity(NotaFiscalVO notaFiscalVo, ClienteEntity cliente) {
		NotaFiscalEntity nota = new NotaFiscalEntity();
		
		nota.setNumero(notaFiscalVo.getNumero());
		nota.setData(LocalDateTime.now());
		nota.setFormaPagamento(notaFiscalVo.getFormaPagamento());
		nota.setCliente(cliente);
		
		return nota;
	}
	
	public NotaFiscalDTO entityToDto(NotaFiscalEntity notaFiscalEntity) {
		NotaFiscalDTO nota = new NotaFiscalDTO();
		nota.setId(notaFiscalEntity.getId());
		nota.setNumero(notaFiscalEntity.getNumero());
		nota.setFormaPagamento(notaFiscalEntity.getFormaPagamento());
		nota.setNomeCliente(notaFiscalEntity.getCliente().getNome());
		
		return nota;
	}
	
}
