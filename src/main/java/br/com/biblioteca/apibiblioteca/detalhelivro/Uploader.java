package br.com.biblioteca.apibiblioteca.detalhelivro;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface Uploader {

	public String upload(MultipartFile file);
}
