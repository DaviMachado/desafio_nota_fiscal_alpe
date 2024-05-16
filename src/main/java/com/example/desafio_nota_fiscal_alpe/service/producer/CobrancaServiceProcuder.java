package com.example.desafio_nota_fiscal_alpe.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;
import com.example.desafio_nota_fiscal_alpe.utils.NotaFiscalUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CobrancaServiceProcuder {

	@Value("${topicos.cobranca-service.topic}")
    private String cobrancaServiceTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
	private NotaFiscalUtils notaFiscalUtils;


    public void sendMessage(NotaFiscalEntity notaFiscal) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(notaFiscalUtils.entityToDto(notaFiscal));
        kafkaTemplate.send(cobrancaServiceTopic, conteudo);
        log.info("Nota Fiscal enviado para o Topic do MS de Cobrança com sucesso !!");
    }
}
