package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.dto.PagamentoDTO;
import com.example.desafio_nota_fiscal_alpe.service.producer.PagamentoRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PagamentoService {
    @Autowired 
    private PagamentoRequestProducer pagamentoProducer;

    public String integrarPagamento(PagamentoDTO pagamento) {
        try {
            return pagamentoProducer.sendMessage(pagamento);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar o pagamento " + e.getMessage();
        }
    }
}
