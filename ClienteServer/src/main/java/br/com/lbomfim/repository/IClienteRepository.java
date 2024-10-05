package br.com.lbomfim.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.lbomfim.domain.Cliente;


/**
 * @author Lucas Bomfim
 *
 */

@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {

	// PROCURAR POR CPF
	Optional<Cliente> findByCpf(Long cpf);

}