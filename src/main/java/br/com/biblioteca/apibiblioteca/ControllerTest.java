package br.com.biblioteca.apibiblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ControllerTest {

	@Operation(description = "Informa que o projeto está configurado.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Retorna Configuracao."),
		@ApiResponse(responseCode = "400", description = "Não configurado.")
	})
	@GetMapping(value = "/api/test")
	public String teste() {
		return "esta configurado";
	}
}
