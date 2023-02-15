package br.com.paulo25.EncLivro.model.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class FormPesquisa {
	@NotBlank(message = "preencha este campo")
	private String texto;
	@NotNull(message = "escolha uma opção válida")
	private TipoPesquisa tipoPesquisa;

	public FormPesquisa() {}

	public FormPesquisa (String texto, TipoPesquisa tipoPesquisa) {
	
		this.texto = texto;
		this.tipoPesquisa = tipoPesquisa;
	}

	public String getTexto() {
		return texto;
	}

	public TipoPesquisa getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setTipoPesquisa(TipoPesquisa tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}
	
	
	
	
	
	

}
