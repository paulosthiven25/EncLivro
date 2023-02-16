package br.com.paulo25.EncLivro.service;

import org.springframework.http.ResponseEntity;

public interface GerenciadorRequisicaoBase {
	
	ResponseEntity<String> consumirApi(String texto,String modoPesquisa);

}
