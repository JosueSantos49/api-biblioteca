package br.com.biblioteca.apibiblioteca.site.detalhe;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;


public class Carrinho {
	
	private List<LivroCarrinhoDTO> livros = new ArrayList<>();
	
	@Deprecated
	public Carrinho() {		
	}

	public void adiciona(Livro livro) {		
		livros.add(new LivroCarrinhoDTO(livro));
	}

	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}
	
	public List<LivroCarrinhoDTO> getLivros() {
		return livros;
	}

}
