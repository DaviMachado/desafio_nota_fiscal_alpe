package com.example.desafio_nota_fiscal_alpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio_nota_fiscal_alpe.domain.entity.NotaFiscalEntity;

@Repository
public interface NotalFiscalRepository extends JpaRepository<NotaFiscalEntity, Long> {

}
