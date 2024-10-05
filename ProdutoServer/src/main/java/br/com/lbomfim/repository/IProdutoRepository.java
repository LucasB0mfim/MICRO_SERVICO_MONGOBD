package br.com.lbomfim.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.lbomfim.domain.Produto;
import br.com.lbomfim.domain.Produto.Status;

/**
 * @author Lucas Bomfim
 *
 */

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String>{
	
	// MÉTODO - PROCURAR POR STATUS
	Page<Produto> findAllByStatus(Pageable pageable, Status status);
	
}
