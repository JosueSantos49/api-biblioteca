package br.com.biblioteca.apibiblioteca.site.detalhe;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;
import jakarta.validation.constraints.Positive;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroCarrinhoDTO {

	private String titulo;
	private BigDecimal preco;
	private String linkCapaLivro;
	private int quantidade = 1;
	
	@Deprecated
	public LivroCarrinhoDTO() {		
	}
	
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public BigDecimal getTotal() {
		return preco.multiply(new BigDecimal(quantidade));
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroCarrinhoDTO other = (LivroCarrinhoDTO) obj;
		return Objects.equals(titulo, other.titulo);
	}

	public void incrementa() {
		this.quantidade++;
	}

	public void atualizaQuantidade(@Positive int novaQuantidade) {	
		
		Assert.isTrue(novaQuantidade > 0, "A quantidade de atualização tem que ser maior do que zero.");
		
		this.quantidade = novaQuantidade;
	}
	
	

}
