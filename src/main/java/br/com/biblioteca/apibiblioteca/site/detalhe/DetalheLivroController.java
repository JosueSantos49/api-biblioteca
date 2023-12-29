package br.com.biblioteca.apibiblioteca.site.detalhe;

import java.net.URLEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.biblioteca.apibiblioteca.detalhelivro.Livro;
import br.com.biblioteca.apibiblioteca.detalhelivro.LivroRepository;
import br.com.biblioteca.apibiblioteca.shared.Cookies;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DetalheLivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private Cookies cookies;
	
	@Operation(description = "Recupera o detalhe do livro pelo ID.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Retorna livro."),
		@ApiResponse(responseCode = "400", description = "Não conseguiu retornar o livro.")
	})
	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO exibeDetalhe(@PathVariable("id") Long id) {
		
		Livro livro = livroRepository.findById(id).get();
		return new LivroDetalheDTO(livro);
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/api/carrinho/{idLivro}")
	public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {
		
		/*
		 *Receber o carrinho pelo cookie(json)
		 *Se não tiver cookie para o carinho, então cria um novo carrinho
		 *Precisa da capa, título, preço 
		 */
		/*
		Carrinho carrinho = jsonCarrinho.map(json ->{
			try {
				
				return new ObjectMapper().readValue(json, Carrinho.class);
				
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho());
		*/
		
		Carrinho carrinho = Carrinho.cria(jsonCarrinho);
		
		//Adiciona o livro no carrinho
		carrinho.adiciona(livroRepository.findById(idLivro).get());
		
		//Gravar o carrinho no cookie
		cookies.writeAsJson("carrinho" ,carrinho, response);		
		
		return carrinho.toString();	
				
	}

}
