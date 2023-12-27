package br.com.biblioteca.apibiblioteca.site.detalhe;

import java.math.BigDecimal;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;

public class LivroDetalheDTO {
	
	private String titulo;
	private String subTitulo;
	private BigDecimal preco;
	private String conteudo;
	private String sumario;
	private int numeroPaginas;
	private String isbn;
	private AutorLivroDetalheDTO autor;
	private Long id;

	public LivroDetalheDTO(Livro livro) {	
		titulo = livro.getTitulo();
		subTitulo = livro.getSubTitulo();
		preco = livro.getPreco();
		conteudo = livro.getConteudo();
		sumario = livro.getSumario();
		autor = new AutorLivroDetalheDTO(livro.getAutor());
		numeroPaginas = livro.getNumeroPaginas();
		isbn = livro.getIsbn();
		id = livro.getId();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public AutorLivroDetalheDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorLivroDetalheDTO autor) {
		this.autor = autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
