package com.example.desafio_nota_fiscal_alpe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.entity.ClienteEntity;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Nota Fiscal Controller")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class NotaFiscalControllerIT extends BaseControllerIT {
	
	private static StringBuilder path = new StringBuilder(URL);
	
	@BeforeEach
	void inicializar() {
		path.append(URL_NOTA_FISCAL);
	}

	@AfterEach
	void finalizar() {
		path = new StringBuilder(URL);
	}
	
	
	@Nested
   	@DisplayName("POST /nota-fiscal")
   	class Post {
    	
    	@Nested
		@DisplayName("Deve retornar http status 201")
		class Sucess {
    		
    		@Test
    	    @DisplayName("Deve salvar uma nova Nota Fiscal")
    	    public void testSalvarNotaFiscal() {
    			ClienteEntity novoCliente = createClienteEntity("76696959009", "teste2@gmail.com");
    			createTokenJwt(novoCliente);
    			
    			NotaFiscalVO novaNotaFiscalVoTest = createNotaFiscalVo(novoCliente.getCpf());
    			
    			HttpEntity<NotaFiscalVO> corpoRequisicao = new HttpEntity<NotaFiscalVO>(novaNotaFiscalVoTest, headers);
    			ResponseEntity<NotaFiscalDTO> corpoResposta = restTemplate.exchange(URL_NOTA_FISCAL, HttpMethod.POST, corpoRequisicao, NotaFiscalDTO.class);

    			assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
    			assertEquals(corpoRequisicao.getBody().getNumero(), corpoResposta.getBody().getNumero());
    			
    			clienteRepository.deleteById(novoCliente.getId());
    		}
    	}
    }
    
    @Nested
	@DisplayName("GET /nota-fiscal")
	class Get {
    	
    	@Nested
		@DisplayName("Deve retornar http status 200")
		class Sucess {
    		
    		@Test
    	    @DisplayName("Deve retornar uma String ao buscar pela Nota Fiscal")
    	    public void testBuscarNotaFiscal() {
    			ClienteEntity novoCliente = createClienteEntity("97308374068", "teste@gmail.com");
    			createTokenJwt(novoCliente);
    			
    			HttpEntity<String> corpoRequisicao = new HttpEntity<String>(headers);
    			ResponseEntity<String> corpoResposta = restTemplate.exchange(URL_NOTA_FISCAL, HttpMethod.GET, corpoRequisicao, String.class);

    			assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
    		    Assert.assertNotNull(corpoResposta.getBody());
    		    Assert.assertTrue(corpoResposta.getBody().contains("Nota fiscal retornada com Sucesso !!!"));
    		    
    		    clienteRepository.deleteById(novoCliente.getId());
    	    }
    	}
    }
    
}
