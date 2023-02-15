package br.com.paulo25.EncLivro.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;





@Service
public class GerenciadorRequisiçãoWebClient implements GerenciadorRequisiçãoBase{
	
	@Value("${EncLivro.Api.ApiKey}")
	private String APIKEY = "";
	@Value("${EncLivro.Api.RootUri}")
	private String ROOTURI;
	

	
	
	
	public ResponseEntity<String> consumirApi(String texto,String modoPesquisa) {
	
	WebClient wc = geradorDeWebClient();
	ResponseEntity<String> objeto = 
	            wc.get()
	            .uri(uriBuilder -> uriBuilder
	            	    .path("/volumes/")
	            	    .queryParam("q", String.join(":", "{pesquisa}", "{texto}"))
	            	    .queryParam("key","{apiKey}")
	            	    //.queryParam("maxResults","1")
	            	    .build(modoPesquisa,texto,APIKEY))
	          .retrieve()
	          .toEntity(String.class).block();
	
	
	return objeto;
	
	
	}
	
	private WebClient geradorDeWebClient() {
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(ROOTURI);
		//factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
		
		WebClient wc = WebClient
		  .builder()
		  .uriBuilderFactory(factory)
		  .baseUrl(ROOTURI)
		  .build();
		
		return wc;
	}
	
	
}
