package br.com.paulo25.EncLivro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private VolumeInfo volumeInfo;
	private String id;

	public Item() {
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}
	
	public String getId() {
		return id;
	}

	public Item(VolumeInfo volumeInfo,String id) {
		this.volumeInfo = volumeInfo;
		this.id = id;
	}

	
	

}
