package br.com.biblioteca.apibiblioteca.detalhelivro;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long>{


	Optional<Livro> findByIsbn(String isbn);

	Optional<Livro> findByTitulo(String titulo);
	
	@Override
	Collection<Livro> findAll();

}
