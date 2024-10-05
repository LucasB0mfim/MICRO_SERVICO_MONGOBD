package br.com.lbomfim.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lbomfim.domain.Cliente;
import br.com.lbomfim.repository.IClienteRepository;
import jakarta.validation.Valid;

/**
 * @author Lucas Bomfim
 */

@Service
public class Cadastro {

	// ATRIBUTO
	private IClienteRepository clienteRepository;

	// CONSTRUTOR
	@Autowired
	public Cadastro(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// MÉTODO (CADASTRAR)
	public Cliente cadastrar(@Valid Cliente cliente) {
		return this.clienteRepository.insert(cliente);
	}

	// MÉTODO (ATUALIZAR)
	public Cliente atualizar(@Valid Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	// MÉTODO (REMOVER)
	public void remover(String id) {
		this.clienteRepository.deleteById(id);
	}
}