package com.example.desafio_nota_fiscal_alpe.domain.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NFe")
public class Nfe {
	
    private InfNFe infNFe;

    public Nfe() {}
    
    public Nfe(InfNFe infNFe) {
        this.infNFe = infNFe;
    }

    @XmlElement(name = "infNFe")
    public InfNFe getInfNFe() {
        return infNFe;
    }

    public void setInfNFe(InfNFe infNFe) {
        this.infNFe = infNFe;
    }
    
}
