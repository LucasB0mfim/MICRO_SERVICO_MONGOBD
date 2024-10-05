package br.com.lbomfim.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lbomfim.domain.Cliente;
import br.com.lbomfim.usecase.Busca;
import br.com.lbomfim.usecase.Cadastro;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

/**
 * @author Lucas Bomfim
 *
 */

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	// ATRIBUTOS
	private Busca buscaCliente;
	private Cadastro cadastroCliente;
	
	// CONSTRUTOR
	@Autowired
	public ClienteResource(Busca buscaCliente, 
			Cadastro cadastroCliente) {
		this.buscaCliente = buscaCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	// CADASTRAR
	@PostMapping
	public ResponseEntity<Cliente> cadastar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
	}
	
	// CONSULTAR
	@GetMapping(value = "isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscaCliente.isCadastrado(id));
	}
	
	// ATUALIZAR
	@PutMapping
	@Operation(summary = "Atualiza um cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
	}	
	

	// DELETAR
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um cliente pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		cadastroCliente.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}

	// BUSCAR
	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscaCliente.buscar(pageable));
	}
	
	// BUSCAR POR ID
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca um cliente pelo id")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscaCliente.buscarPorId(id));
	}
	
	//BUSCAR POR CPF
	@GetMapping(value = "/cpf/{cpf}")
	@Operation(summary = "Busca um cliente pelo cpf")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
		return ResponseEntity.ok(buscaCliente.buscarPorCpf(cpf));
	}
}