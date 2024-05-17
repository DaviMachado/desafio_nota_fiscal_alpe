package com.example.desafio_nota_fiscal_alpe.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.example.desafio_nota_fiscal_alpe.DesafioNotaFiscalAlpeApplication;
import com.example.desafio_nota_fiscal_alpe.domain.dto.RespostaLoginDTO;
import com.example.desafio_nota_fiscal_alpe.domain.entity.ClienteEntity;
import com.example.desafio_nota_fiscal_alpe.domain.enums.FormaDePagamentoEnum;
import com.example.desafio_nota_fiscal_alpe.domain.vo.AccountCredentialsVO;
import com.example.desafio_nota_fiscal_alpe.domain.vo.ClienteVO;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.repository.ClienteRepository;

@SuppressWarnings("resource")
@SpringBootTest(classes = { DesafioNotaFiscalAlpeApplication.class })
@ActiveProfiles("test")
public abstract class BaseControllerIT {
	
	protected static final String URL = "http://localhost:3030/alpe";
	
	protected static final String URL_LOGIN = "/login";
	
	protected static final String URL_NOTA_FISCAL = "/nota-fiscal";

	protected static final String SENHA_PADRAO = "SENHA_PADRAO";

	protected static HttpHeaders headers;

	@Autowired
	protected TestRestTemplate restTemplate;
	
	@Autowired
	protected ClienteRepository clienteRepository;
	

	protected ClienteEntity createClienteEntity(String cpf, String email) {
		ClienteEntity cliente = new ClienteEntity();
		
		cliente.setNome("teste unitario");
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setSenha(SENHA_PADRAO);
		
		return clienteRepository.save(cliente);
	}
	
	protected NotaFiscalVO createNotaFiscalVo(String cpf) {
		NotaFiscalVO novaNotaFiscalVoTest = new NotaFiscalVO();
		ClienteVO novoClienteVoTest = new ClienteVO();
		
		novaNotaFiscalVoTest.setNumero(123456789L);
		novaNotaFiscalVoTest.setFormaPagamento(FormaDePagamentoEnum.BOLETO.getDescricao());
		novoClienteVoTest.setCpf(cpf);
		novaNotaFiscalVoTest.setCliente(novoClienteVoTest);
		
		return novaNotaFiscalVoTest;
	}

	protected void createTokenJwt(ClienteEntity cliente) {
		String token = obtainAccessToken(cliente.getEmail(), cliente.getSenha());
		headers = obtainHeadersRequest(token);
	}

	protected String obtainAccessToken(final String email, final String senha) {
		AccountCredentialsVO login = new AccountCredentialsVO();
		login.setEmail(email);
		login.setPassword(senha);

		HttpEntity<AccountCredentialsVO> corpoRequisicao = new HttpEntity<AccountCredentialsVO>(login);
		ResponseEntity<RespostaLoginDTO> corpoResposta = restTemplate.exchange(URL + URL_LOGIN, HttpMethod.POST, corpoRequisicao, RespostaLoginDTO.class);

		return corpoResposta.getBody().getToken();
	}

	protected HttpHeaders obtainHeadersRequest(final String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		return headers;
	}

}
