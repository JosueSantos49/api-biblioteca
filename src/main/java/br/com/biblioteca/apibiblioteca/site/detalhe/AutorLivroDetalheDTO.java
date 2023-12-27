package br.com.biblioteca.apibiblioteca.site.detalhe;

import br.com.biblioteca.apibiblioteca.detalhelivro.Autor;

public class AutorLivroDetalheDTO {
	
	private String nome;
	private String descricao;

	public AutorLivroDetalheDTO(Autor autor) {
		nome = autor.getNome();
		descricao = "Aqui precisa vir a descricao do autor.";
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
