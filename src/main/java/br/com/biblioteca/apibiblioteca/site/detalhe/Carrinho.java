package br.com.biblioteca.apibiblioteca.site.detalhe;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;
import jakarta.validation.constraints.Positive;


public class Carrinho {
	
	//Manter a ordem de inserir
	private Set<LivroCarrinhoDTO> livros = new LinkedHashSet<>();
	
	@Deprecated
	public Carrinho() {		
	}

	public void adiciona(Livro livro) {		
		LivroCarrinhoDTO novoItem = new LivroCarrinhoDTO(livro);
		boolean result = livros.add(novoItem);
		
		if(!result) {
			LivroCarrinhoDTO itemExistente = livros.stream().filter(novoItem :: equals).findFirst().get();
			itemExistente.incrementa();
		}
	}

	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}
	
	public Set<LivroCarrinhoDTO> getLivros() {
		return livros;
	}
	
	/*
	 * @param jsonCarrinho possível json de um carrinho já criado
	 * @return
	 * */
	public static Carrinho cria(Optional<String> jsonCarrinho) {
		return  jsonCarrinho.map(json ->{
			try {
				
				return new ObjectMapper().readValue(json, Carrinho.class);
				
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho());
	}

	public void atualiza(Livro livro, @Positive int novaQuantidade) {
		
		Assert.isTrue(novaQuantidade > 0, "A quantidade de atualização tem que ser maior do que zero.");
		
		LivroCarrinhoDTO possivelItemAdicionado = new LivroCarrinhoDTO(livro);
		Optional<LivroCarrinhoDTO> possivelItem = livros.stream().filter(possivelItemAdicionado :: equals).findFirst();
		
		Assert.isTrue(possivelItem.isPresent(), "Você não deveria atualizar um livro que não foi colocado no carrinho.");
		
		LivroCarrinhoDTO itemQueExiste = possivelItem.get();
		itemQueExiste.atualizaQuantidade(novaQuantidade);
	}

}
