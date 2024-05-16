package com.example.desafio_nota_fiscal_alpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_nota_fiscal_alpe.domain.dto.PagamentoDTO;
import com.example.desafio_nota_fiscal_alpe.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoAPI {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public String pagar (@RequestBody PagamentoDTO pagamento) {
        return pagamentoService.integrarPagamento(pagamento);
    }

}
