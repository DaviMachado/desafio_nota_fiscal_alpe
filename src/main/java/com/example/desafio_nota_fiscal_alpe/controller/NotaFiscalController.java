package com.example.desafio_nota_fiscal_alpe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.model.Nfe;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.service.NotaFiscalServiceImpl;
import com.example.desafio_nota_fiscal_alpe.service.NotaFiscalXmlService;

@RestController
@RequestMapping("/nota-fiscal")
public class NotaFiscalController {
	
	@Autowired
	private NotaFiscalServiceImpl notaFiscalServiceImpl;
	@Autowired
    private NotaFiscalXmlService notaFiscalXmlService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public NotaFiscalDTO salvarNotaFiscal(@RequestBody @Valid NotaFiscalVO notaFiscal) {
		return notaFiscalServiceImpl.salvarNotaFiscal(notaFiscal);
    }
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public String listarNotasFiscais() {
		return notaFiscalServiceImpl.listarNotasFiscais();
	}
	
	@GetMapping("/upload-xml-listar")
	@ResponseStatus(HttpStatus.OK)
	public Nfe listarNotaFiscalComXml(@RequestParam("file") MultipartFile file) {
		return notaFiscalXmlService.listarNotaFiscalXml(file);
	}
	
	@PostMapping("/upload-xml")
	@ResponseStatus(HttpStatus.OK)
	public NotaFiscalDTO salvarNotaFiscalComXml(@RequestParam("file") MultipartFile file) {
		return notaFiscalXmlService.salvarNotaFiscalXml(file);
	}

}
