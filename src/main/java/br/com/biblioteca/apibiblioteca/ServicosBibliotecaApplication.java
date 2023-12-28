package br.com.biblioteca.apibiblioteca;

import org.apache.tomcat.util.http.CookieProcessor;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@Configuration(proxyBeanMethods = false)
@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ServicosBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicosBibliotecaApplication.class, args);
	}
	
	//Validacao de valor de cookie - Use Tomcat LegacyCookieProcessor
	
	@Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return (factory) -> factory
                .addContextCustomizers((context) -> context.setCookieProcessor(new Rfc6265CookieProcessor()));
    }
	
	
	/* 
	@Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> webServerFactoryCustomizer() {
         return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
             @Override
             public void customize(TomcatServletWebServerFactory factory) {
                 TomcatServletWebServerFactory tomcat = (TomcatServletWebServerFactory) factory;
                 tomcat.addContextCustomizers(context -> context.setCookieProcessor(new Rfc6265CookieProcessor()));
             }
         };
     }
	 */
}
