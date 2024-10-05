package br.com.lbomfim.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas Bomfim
 *
 */

@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
	
	public enum Status {
		ATIVO, INATIVO;
	}
	
	@Id
	@Schema(description = "Identificador único")
	private String id;
	
	@NotNull
	@Schema(description = "Nome", nullable = false)
	private String nome;
	
	@NotNull
	@Schema(description = "Valor", nullable = false)
	private BigDecimal valor;
	
	private Status status;
}