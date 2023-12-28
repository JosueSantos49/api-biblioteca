package br.com.biblioteca.apibiblioteca.site.detalhe;

import java.math.BigDecimal;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;

public class LivroCarrinhoDTO {

	private String titulo;
	private BigDecimal preco;
	private String linkCapaLivro;
	
	public LivroCarrinhoDTO(Livro livro) {
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		linkCapaLivro = livro.getLinkCapaLivro();	
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}
	
	

}
