package com.example.desafio_nota_fiscal_alpe.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "NOTA_FISCAL")
public class NotaFiscalEntity extends AbstractEntity {

	private String texto;

}
