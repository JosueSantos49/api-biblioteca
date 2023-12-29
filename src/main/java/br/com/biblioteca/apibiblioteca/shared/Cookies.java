package br.com.biblioteca.apibiblioteca.shared;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.biblioteca.apibiblioteca.site.detalhe.Carrinho;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Cookies {

	/*
	 * @param key chave que vai ser gerada para o cookie
	 * @param carrinho de compras que vai ser serializado
	 * @param response
	 * */
	public void writeAsJson(String key, Carrinho carrinho, HttpServletResponse response) {
		
		
		try {
			String encodeCookieCarrinho = URLEncoder.encode(key, new ObjectMapper().writeValueAsString(carrinho));
			
			//Adiciona o cookie
			//Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
			Cookie cookie = new Cookie("carrinho", encodeCookieCarrinho);
			cookie.setHttpOnly(true);
			cookie.setMaxAge(24 * 60 * 60);		
			
			//Adicionar cookie no Header da resposta
			response.addCookie(cookie);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		
		
	}

}
