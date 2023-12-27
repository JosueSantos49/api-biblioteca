package br.com.biblioteca.apibiblioteca.detalhelivro;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Size(max = 100) String titulo;
	private @Size(max = 50) String subTitulo;
	private @Min(20) BigDecimal preco;
	private @NotBlank String conteudo;
	private @NotBlank String sumario;
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;
	private @NotBlank String linkCapaLivro;
	
	//Varios links para um autor
	@ManyToOne
	private @NotBlank Autor autor;
	
	@Deprecated
	public Livro() {		
	}
	
	public Livro(@NotBlank @Size(max = 100) String titulo, @Size(max = 50) String subTitulo, @Min(20) BigDecimal preco,
			@NotBlank String conteudo, @NotBlank String sumario, @Min(100) int numeroPaginas, @NotBlank String isbn,
			@NotBlank String linkCapaLivro, @NotBlank Autor autor) {
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.preco = preco;
		this.conteudo = conteudo;
		this.sumario = sumario;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.linkCapaLivro = linkCapaLivro;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", subTitulo=" + subTitulo + ", preco=" + preco + ", conteudo=" + conteudo
				+ ", sumario=" + sumario + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", linkCapaLivro="
				+ linkCapaLivro + ", autor=" + autor + "]";
	}

	public Long getId() {
		return id;
	}
		
	public String getTitulo() {
		return titulo;
	}
	
	public Autor getAutor() {
		return autor;
	}
	
}
