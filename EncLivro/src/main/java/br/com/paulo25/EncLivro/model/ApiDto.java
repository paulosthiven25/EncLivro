package br.com.paulo25.EncLivro.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true) 
public class ApiDto {
	
	private List<Item> items = new ArrayList<Item>();
	
	public ApiDto() {
		this(new ArrayList<Item>());
	}
	


	public ApiDto(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	
	
	
	
}
