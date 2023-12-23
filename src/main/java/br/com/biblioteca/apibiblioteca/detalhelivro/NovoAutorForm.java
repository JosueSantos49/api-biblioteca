package br.com.biblioteca.apibiblioteca.detalhelivro;

import jakarta.validation.constraints.NotBlank;

public class NovoAutorForm {

	@NotBlank
	private String nome;
	
	
	@NotBlank		
	private String linkGithub;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLinkGithub() {
		return linkGithub;
	}


	public void setLinkGithub(String linkGithub) {
		this.linkGithub = linkGithub;
	}
	
	public Autor novoAutor() {
		return new Autor(nome, linkGithub);
	}
	
	
}
