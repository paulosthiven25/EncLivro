package br.com.paulo25.EncLivro.model.dto;



import java.util.ArrayList;
import java.util.List;

public class RespostaDto {
	
	private String titulo;
	private List<String> autor = new ArrayList<>();
	private String datapublicacao;
	private String imagem;
	
	
	
	public RespostaDto(String titulo, List<String> autor, String datapublicacao, String imagem) {
		this.titulo = titulo;
		this.autor = autor;
		this.datapublicacao = datapublicacao;
		this.imagem = imagem;
	}
	
	public RespostaDto() {
		super();
	}






	public String getTitulo() {
		return titulo;
	}
	public List<String> getAutor() {
		return autor;
	}
	public String getDatapublicacao() {
		return datapublicacao;
	}
	public String getImagem() {
		return imagem;
	}
	
	

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(List<String> autor) {
		this.autor = autor;
	}

	public void setDatapublicacao(String datapublicacao) {
		this.datapublicacao = datapublicacao;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	
	
	
	

}
