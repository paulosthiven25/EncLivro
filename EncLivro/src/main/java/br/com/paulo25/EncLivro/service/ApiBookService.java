package br.com.paulo25.EncLivro.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import br.com.paulo25.EncLivro.model.dto.ApiDto;
import br.com.paulo25.EncLivro.model.dto.FormPesquisa;


@Service
public class ApiBookService {
	private final String apikey ="AIzaSyBK8tNjmapxoetp0gngu-wUGUt7WYEqZ2g";
	
	@Autowired
	private GerenciadorRequisição gr;
	
	
	
	
	public ApiDto consumir(FormPesquisa form) {
	 String pesquisa = form.getTipopesquisa().getValue();
	    String texto = form.getTexto();
	 WebClient wb = gr.BuiderReuqisição();
	    
	    ApiDto objeto = 
	            wb.get()
	            .uri(uriBuilder -> uriBuilder
	            	    .path("/volumes/")
	            	    .queryParam("q", String.join(":", "{pesquisa}", "{texto}"))
	            	    .queryParam("key","{apiKey}")
	            	    .build(pesquisa,texto,apikey))
	            	  .retrieve()
	            .bodyToMono(ApiDto.class).block();
	    
	    return objeto;
	
	}
	

	
	
	
	
	

}
	