package com.example.desafio_nota_fiscal_alpe.domain.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cliente")
public class Cliente {

	private String cpf;

    public Cliente() {}
    
    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    @XmlElement(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
