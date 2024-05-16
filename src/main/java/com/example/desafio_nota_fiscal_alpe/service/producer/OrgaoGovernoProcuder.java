package com.example.desafio_nota_fiscal_alpe.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrgaoGovernoProcuder {

	@Value("${topicos.orgao-governo.topic}")
    private String orgaoGovernoTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(NotaFiscalVO notaFiscal) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(notaFiscal);
        kafkaTemplate.send(orgaoGovernoTopic, conteudo);
        log.info("Nota Fiscal enviado para o Topic do Orgão do Governo para validação !!");
    }
}
