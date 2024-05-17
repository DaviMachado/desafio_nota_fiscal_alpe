package com.example.desafio_nota_fiscal_alpe.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "NOTA_FISCAL")
public class NotaFiscalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NUMERO_NOTA")
	private Long numero;
	
	@Column(name = "DATA_NOTA")
	private LocalDateTime data;
	
	@Column(name = "FORMA_PAGAMENTO")
	private String formaPagamento;
	
	@ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private ClienteEntity cliente;

}
