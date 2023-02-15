package br.com.paulo25.EncLivro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageLinks {
	
	private String thumbnail;
	
	

	public ImageLinks() {
		this("https://www.ncenet.com/wp-content/uploads/2020/04/no-image-png-2.png");
	}

	public ImageLinks(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail ) {
		this.thumbnail = thumbnail;
	}
}
