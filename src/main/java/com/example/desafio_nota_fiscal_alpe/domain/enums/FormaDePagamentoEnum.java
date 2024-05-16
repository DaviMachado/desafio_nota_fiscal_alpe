package com.example.desafio_nota_fiscal_alpe.domain.enums;

public enum FormaDePagamentoEnum {
    DINHEIRO(1, "Dinheiro"),
    CARTAO_CREDITO(2, "Cartão de Crédito"),
    CARTAO_DEBITO(3, "Cartão de Débito"),
    PIX(4, "PIX"),
    BOLETO(5, "Boleto");

    private final int id;
    private final String descricao;

    FormaDePagamentoEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}

