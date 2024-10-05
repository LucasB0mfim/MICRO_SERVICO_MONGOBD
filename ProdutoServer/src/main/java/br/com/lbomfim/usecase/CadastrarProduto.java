package br.com.lbomfim.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lbomfim.domain.Produto;
import br.com.lbomfim.domain.Produto.Status;
import br.com.lbomfim.repository.IProdutoRepository;
import jakarta.validation.Valid;

/**
 * @author Lucas Bomfim
 *
 */

@Service
public class CadastrarProduto {
	
	// ATRIBUTO
	private IProdutoRepository produtoRepository;
	
	// CONSTRUTOR
	@Autowired
	public CadastrarProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	// MÉTODO (1)
	public Produto cadastrar(@Valid Produto produto) {	
		
		produto.setStatus(Status.ATIVO);
		return this.produtoRepository.insert(produto);		
	}

	// MÉTODO (2)
	public Produto atualizar(@Valid Produto produto) {	
		
		return this.produtoRepository.save(produto);		
	}

	// MÉTODO (3)
	public void remover(String id) {	
		
		Produto prod = produtoRepository.findById(id).orElseThrow();
		prod.setStatus(Status.INATIVO);
		this.produtoRepository.save(prod);		
	}
}
