package br.com.paulo25.EncLivro.model.dto;

import javax.validation.constraints.NotBlank;

public class FormPesquisa {
	@NotBlank
	private String texto;
	
	private TipoPesquisa tipopesquisa;

	public FormPesquisa() {}

	public FormPesquisa (String texto, TipoPesquisa tipopesquisa) {
	
		this.texto = texto;
		this.tipopesquisa = tipopesquisa;
	}

	public String getTexto() {
		return texto;
	}

	public TipoPesquisa getTipopesquisa() {
		return tipopesquisa;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setTipopesquisa(TipoPesquisa tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}
	
	
	
	
	
	

}
