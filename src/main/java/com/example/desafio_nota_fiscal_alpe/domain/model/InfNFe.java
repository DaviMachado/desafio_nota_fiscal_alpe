package com.example.desafio_nota_fiscal_alpe.domain.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "infNFe")
public class InfNFe {

	private String numero;
	private String formaPagamento;
	private Cliente cliente;

    public InfNFe() {}
    
    public InfNFe(String numero, String formaPagamento, Cliente cliente) {
        this.numero = numero;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
    }

    @XmlElement(name = "numero")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    @XmlElement(name = "formaPagamento")
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    @XmlElement(name = "cliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
