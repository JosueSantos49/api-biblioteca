package br.com.biblioteca.apibiblioteca.detalhelivro;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements Uploader{

	@Override
	public String upload(MultipartFile file) {
		System.out.println("enviando aquivo...");
		return "http://s3.amazon/bucket/"+file.getOriginalFilename();
	}

}
