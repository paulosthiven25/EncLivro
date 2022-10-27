package br.com.paulo25.EncLivro.service;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Service
public class GerenciadorRequisição {
	
	
		
	private final String url = "https://www.googleapis.com/books/v1";
	   
	
	
	public WebClient BuiderReuqisição() {
	DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
	factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
	
	WebClient webClient = WebClient
	  .builder()
	  .uriBuilderFactory(factory)
	  .baseUrl(url)
	  .build();
	
	
	
	
	return webClient;
	
	
	}
	
	
	
}
