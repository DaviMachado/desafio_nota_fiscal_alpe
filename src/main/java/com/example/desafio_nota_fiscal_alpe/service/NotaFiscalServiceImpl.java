package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.domain.enums.FormaDePagamentoEnum;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.exception.NotaFiscalErrorException;
import com.example.desafio_nota_fiscal_alpe.repository.NotalFiscalRepository;
import com.example.desafio_nota_fiscal_alpe.utils.NotaFiscalUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotaFiscalServiceImpl implements INotaFiscalService {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CobrancaService cobrancaService;
	@Autowired
	private OrgaoGovernoService orgaoGovernoService;
	@Autowired
	private NotalFiscalRepository notalFiscalRepository;
	@Autowired
	private NotaFiscalUtils notaFiscalUtils;
	

	@Override
	public NotaFiscalDTO salvarNotaFiscal(NotaFiscalVO notaFiscal) {
		try {
			orgaoGovernoService.validarNotaFiscal(notaFiscal);
			NotaFiscalEntity novaNotaFiscal = notalFiscalRepository.save(notaFiscalUtils.voToEntity(notaFiscal, clienteService.validarExistenciaCliente(notaFiscal.getCliente().getCpf())));
			
			if (notaFiscal.getFormaPagamento().equals(FormaDePagamentoEnum.BOLETO.getDescricao())) {				
				cobrancaService.enviar(novaNotaFiscal);
			}
			
			return notaFiscalUtils.entityToDto(novaNotaFiscal);
		} catch (Exception e) {
			new NotaFiscalErrorException("Erro ao salvar um nova Nota Fiscal !!", HttpStatus.BAD_REQUEST);
			log.error("Erro ao salvar um nova Nota Fiscal !!");
		}
		return null;
	}

	@Override
	public String listarNotasFiscais() {
		return "Nota fiscal !!!";
	}

}
