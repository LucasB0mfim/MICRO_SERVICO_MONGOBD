package br.com.lbomfim.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lbomfim.domain.Cliente;
import br.com.lbomfim.repository.IClienteRepository;

/**
 * @author Lucas Bomfim
 */

@Service
public class Busca {

	// ATRIBUTO
	private IClienteRepository clienteRepository;

	// CONSTRUTOR
	@Autowired
	public Busca(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// MÉTODO (CONSULTAR CLIENTE)
	public Boolean isCadastrado(String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isPresent() ? true : false;
	}

	// MÉTODO (BUSCAR TUDO)
	public Page<Cliente> buscar(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	// MÉTODO (BUSCAR POR ID)
	public Cliente buscarPorId(String id) {
		return clienteRepository.findById(id).orElseThrow();
	}

	// MÉTODO (BUSCAR POR CPF)
	public Cliente buscarPorCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf).orElseThrow();
	}
}
