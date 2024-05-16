package com.example.desafio_nota_fiscal_alpe.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.entity.ClienteEntity;
import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.exception.ClienteNaoEncontradoException;
import com.example.desafio_nota_fiscal_alpe.repository.ClienteRepository;
import com.example.desafio_nota_fiscal_alpe.repository.NotalFiscalRepository;

@Service
public class NotaFiscalServiceImpl implements INotaFiscalService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private NotalFiscalRepository notalFiscalRepository;
//	@Autowired(required=true)
//	private NotaFiscalUtils notaFiscalUtils;
	

	@Override
	public NotaFiscalDTO salvarNotaFiscal(NotaFiscalVO notaFiscal) {
		NotaFiscalEntity novaNotaFiscal = notalFiscalRepository.save(voToEntity(notaFiscal, validarExistenciaCliente(notaFiscal.getCliente().getCpf())));
		return entityToDto(novaNotaFiscal);
	}

	@Override
	public String listarNotasFiscais() {
		return "Nota fiscal !!!";
	}
	
	private ClienteEntity validarExistenciaCliente(String cpf) {
		return clienteRepository.findByCpf(cpf).orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado", HttpStatus.BAD_REQUEST));
	}
	
	private NotaFiscalEntity voToEntity(NotaFiscalVO notaFiscalVo, ClienteEntity cliente) {
		NotaFiscalEntity nota = new NotaFiscalEntity();
		
		nota.setNumero(notaFiscalVo.getNumero());
		nota.setData(LocalDateTime.now());
		nota.setFormaPagamento(notaFiscalVo.getFormaPagamento());
		nota.setCliente(cliente);
		
		return nota;
	}
	
	private NotaFiscalDTO entityToDto(NotaFiscalEntity notaFiscalEntity) {
		NotaFiscalDTO nota = new NotaFiscalDTO();
		nota.setId(notaFiscalEntity.getId());
		nota.setNumero(notaFiscalEntity.getNumero());
		nota.setFormaPagamento(notaFiscalEntity.getFormaPagamento());
		nota.setNomeCliente(notaFiscalEntity.getCliente().getNome());
		
		return nota;
	}

}
