package br.com.biblioteca.apibiblioteca.detalhelivro;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Autor {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotBlank String nome;				
	
	private @NotBlank String linkGithub;
	
	@PastOrPresent
	private LocalDateTime createAt = LocalDateTime.now();

	public Autor(@NotBlank String nome, @NotBlank String linkGithub) {
		this.nome = nome;
		this.linkGithub = linkGithub;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", linkGithub=" + linkGithub + ", createAt=" + createAt + "]";
	}
	
	

}
