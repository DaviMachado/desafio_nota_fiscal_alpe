package com.example.desafio_nota_fiscal_alpe.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CobrancaServiceConsumer {

    @KafkaListener(
        topics = "${topicos.cobranca-service.topic}",
        groupId = "cobranca-service")
    public void consumeMessage(String message) {
        log.info("========= Mensagem recebida no Topic do MS de Cobrança ========= - " + message);
    }
}
