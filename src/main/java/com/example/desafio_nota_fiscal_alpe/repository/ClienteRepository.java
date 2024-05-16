package com.example.desafio_nota_fiscal_alpe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio_nota_fiscal_alpe.domain.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	Optional<ClienteEntity> findByCpf(String cpf);

}
