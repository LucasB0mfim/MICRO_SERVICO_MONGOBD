package br.com.lbomfim.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lucas Bomfim 
 */

@Document(collection = "cliente")
@Getter
@Setter
@AllArgsConstructor
@Builder
@Schema(name = "Cliente", description = "Cliente")
public class Cliente {
	@Id
	@Schema(description = "Identificador único")
	private String id;
	
	@NotNull
	@Schema(description = "Nome", nullable = false)
	private String nome;
	
	@NotNull
	@Schema(description = "CPF", nullable = false)
	private Long cpf;
	
	@Schema(description = "Telefone", minLength = 10, maxLength = 11)
	private Long telefone;
}
