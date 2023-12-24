package br.com.biblioteca.apibiblioteca.detalhelivro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nome;
	
	@Deprecated
	public Categoria() {
	}

	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	
}
