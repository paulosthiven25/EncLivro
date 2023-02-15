package br.com.paulo25.EncLivro.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.paulo25.EncLivro.model.ApiDto;
import br.com.paulo25.EncLivro.model.Dto.FormPesquisa;


@Service
public class ApiBookService {
	
	
	@Autowired
	private GerenciadorRequisiçãoBase grb;
	
	
	
	
	public ApiDto consumir(FormPesquisa form) {
	 String pesquisa = form.getTipoPesquisa().getValue();
	    String texto = form.getTexto();
	
	    
	    ResponseEntity<String> jsonResponse =  grb.consumirApi(texto, pesquisa);
	    
	   
	  
	    ObjectMapper objectMapper = new ObjectMapper();
	    ApiDto apiDto = null;
		try {
			apiDto = objectMapper.readValue(jsonResponse.getBody(),ApiDto.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  
	    
	    return apiDto;
	
	}
	
	
	

	
	
	
	
	

}
	