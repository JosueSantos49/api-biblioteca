package br.com.biblioteca.apibiblioteca.detalhelivro;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);

}
