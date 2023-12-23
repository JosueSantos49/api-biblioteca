package br.com.biblioteca.apibiblioteca.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class CrudAutoresController {
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping(value = "/api/autor")
	@Transactional
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		autorRepository.save(novoAutor);
	}
}
