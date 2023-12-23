package br.com.biblioteca.apibiblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ServicosBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicosBibliotecaApplication.class, args);
	}

}
