package br.com.paulo25.EncLivro.model.Dto;



import java.util.ArrayList;
import java.util.List;

public class RespostaDto {
	
	private String titulo;
	private List<String> autor = new ArrayList<>();
	private String dataPublicacao;
	private String imagem;
	
	
	
	public RespostaDto(String titulo, List<String> autor, String dataPublicacao, String imagem) {
		this.titulo = titulo;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
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
	public String getDataPublicacao() {
		return dataPublicacao;
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

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	
	
	
	

}
