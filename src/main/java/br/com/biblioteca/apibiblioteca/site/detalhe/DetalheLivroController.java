package br.com.biblioteca.apibiblioteca.site.detalhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;
import br.com.biblioteca.apibiblioteca.detalhelivro.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class DetalheLivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Operation(description = "Recupera o detalhe do livro pelo ID.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Retorna livro."),
		@ApiResponse(responseCode = "400", description = "Não conseguiu retornar o livro.")
	})
	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO getMethodName(@PathVariable("id") Long id) {
		
		Livro livro = livroRepository.findById(id).get();
		return new LivroDetalheDTO(livro);
	}

}
