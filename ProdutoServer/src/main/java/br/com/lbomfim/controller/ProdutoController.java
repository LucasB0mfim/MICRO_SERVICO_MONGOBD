package br.com.lbomfim.controller;

import jakarta.validation.Valid;

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

import br.com.lbomfim.domain.Produto;
import br.com.lbomfim.domain.Produto.Status;
import br.com.lbomfim.usecase.BuscarProduto;
import br.com.lbomfim.usecase.CadastrarProduto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author Lucas Bomfim
 *
 */

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

	// ATRIBUTOS
	private BuscarProduto buscarProduto;
	private CadastrarProduto cadastrarProduto;

	// CONSTRUTOR
	@Autowired
	public ProdutoController(BuscarProduto buscarProduto, CadastrarProduto cadastrarProduto) {
		this.buscarProduto = buscarProduto;
		this.cadastrarProduto = cadastrarProduto;
	}

	// CADASTRAR
	@PostMapping
	@Operation(summary = "Cadastrar um produto")
	public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {

		return ResponseEntity.ok(cadastrarProduto.cadastrar(produto));
	}

	// ATUALIZAR
	@PutMapping
	@Operation(summary = "Atualiza um produto")
	public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {

		return ResponseEntity.ok(cadastrarProduto.atualizar(produto));
	}

	// EXCLUIR
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um produto pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {

		cadastrarProduto.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}

	// BUSCAR
	@GetMapping
	@Operation(summary = "Busca uma lista paginada de produtos")
	public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {

		return ResponseEntity.ok(buscarProduto.buscar(pageable));
	}
}