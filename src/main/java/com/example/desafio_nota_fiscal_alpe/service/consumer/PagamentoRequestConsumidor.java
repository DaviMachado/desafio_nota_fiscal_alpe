package com.example.desafio_nota_fiscal_alpe.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestConsumidor {

    @KafkaListener(
        topics = "${topicos.pagamento.request.topic}",
        groupId = "pagamento-request-1")
    public void consumeMessage(String message) {
        System.out.println("========= Mensagem recebida =========\n" + message);
    }
}
