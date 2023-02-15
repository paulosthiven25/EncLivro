package br.com.paulo25.EncLivro.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import br.com.paulo25.EncLivro.model.ApiDto;
import br.com.paulo25.EncLivro.model.ImageLinks;
import br.com.paulo25.EncLivro.model.Item;
import br.com.paulo25.EncLivro.model.VolumeInfo;
import br.com.paulo25.EncLivro.model.Dto.RespostaDto;

public class ConversorDeDto {

	public static List<RespostaDto> converterJsonEmRespostDto(ApiDto apidto) {

		List<RespostaDto> listaRespostas = new ArrayList<>();
		
		if(apidto.getItems().isEmpty()) {
			return Collections.unmodifiableList(listaRespostas);
		}
		
		for (Item items : apidto.getItems()) {
			VolumeInfo vf = Optional.ofNullable(items.getVolumeInfo()).orElse(new VolumeInfo());
			
				String title = Optional.ofNullable(vf.getTitle()).orElse("Titulo não disponível");
				List<String> authors = Optional.ofNullable(vf.getAuthors()).orElse(Collections.emptyList());
				String publishedDate = Optional.ofNullable(vf.getPublishedDate()).orElse("data não disponível");
				ImageLinks imageLinks = Optional.ofNullable(vf.getImageLinks()).orElse(new ImageLinks());
				
				listaRespostas.add(
				new RespostaDto(
				title,authors,FormatadoraDeStringsDeDatas.converterDatasString(publishedDate),imageLinks.getThumbnail()));
		
			
		}

		return listaRespostas;

	}

	

}
