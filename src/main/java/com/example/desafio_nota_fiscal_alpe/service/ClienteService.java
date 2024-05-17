package com.example.desafio_nota_fiscal_alpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.example.desafio_nota_fiscal_alpe.domain.entity.ClienteEntity;
import com.example.desafio_nota_fiscal_alpe.exception.ClienteNaoEncontradoException;
import com.example.desafio_nota_fiscal_alpe.repository.ClienteRepository;

@Service
public class ClienteService implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteEntity validarExistenciaCliente(String cpf) {
		return clienteRepository.findByCpf(cpf).orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado", HttpStatus.BAD_REQUEST));
	}
	
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		 	ClienteEntity usuario = this.clienteRepository.findByEmail(email);

	        UserBuilder builder = null;
	        if (usuario != null) {	            
	        	return User.withUsername(
	        			usuario.getEmail())
	        			.password(usuario.getSenha()).roles("CLIENT").build();

	        } else {
	            throw new UsernameNotFoundException("Usuário não encontrado!!");
	        }
	    }
	
}
