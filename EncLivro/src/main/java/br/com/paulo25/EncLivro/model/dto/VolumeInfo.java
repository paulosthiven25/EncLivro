package br.com.paulo25.EncLivro.model.dto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class VolumeInfo {
	private String title;
	private List<String> authors = new ArrayList<String>();
	private String publishedDate;
	private ImageLinks imageLinks;

	public VolumeInfo() {
		this("",Collections.emptyList(),"",new ImageLinks());
	}

	

	public VolumeInfo(String title, List<String> authors, String publishedDate, ImageLinks imageLinks) {
		super();
		this.title = title;
		this.authors = authors;
		this.publishedDate = publishedDate;
		this.imageLinks = imageLinks;
	}
	
	







	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getPublishedDate() {
		return publishedDate;
	}
	
	

	public ImageLinks getImageLinks() {
		return imageLinks;
	}



	@Override
	public String toString() {
		return "Titulo do livro: " + title + "Autor: "+ authors.toString() + "Data de publicação: "+ publishedDate;
	}

	 

}
