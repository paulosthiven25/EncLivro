package br.com.paulo25.EncLivro.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.paulo25.EncLivro.model.dto.ApiDto;
import br.com.paulo25.EncLivro.model.dto.ImageLinks;
import br.com.paulo25.EncLivro.model.dto.Item;
import br.com.paulo25.EncLivro.model.dto.RespostaDto;
import br.com.paulo25.EncLivro.model.dto.VolumeInfo;

class ConversorDeDtoTest {
	private ApiDto apidto;
	
	@BeforeEach
	public void inicializar() {
		ArrayList<String> a = new ArrayList<>();
		a.add("pao1");
		a.add("pao2");
		VolumeInfo vf = new VolumeInfo("pao",a,"2000-10-20",new ImageLinks("link"));
		Item item = new Item(vf,"");
		ArrayList<Item> items = new ArrayList<>();
		
		items.add(item);
	
		apidto = new ApiDto(items);
		
	}

	@Test
	void deveriaGerarUmaListaDeRespostaDtoAtravesDeUmApiDto() {

		List<RespostaDto> lista = ConversorDeDto.converterJsonEmRespostDto(apidto);
		RespostaDto rd = new RespostaDto() ;
		
		for (RespostaDto respostaDto : lista) {
			rd = respostaDto;
		}
	
		Assertions.assertEquals("pao",rd.getTitulo());
		Assertions.assertTrue(rd.getAutor().contains("pao1"));
		Assertions.assertTrue(rd.getAutor().contains("pao2"));
		Assertions.assertEquals("20/10/2000",rd.getDatapublicacao());
		Assertions.assertEquals("link",rd.getImagem());
		
	}
	
	@Test
	void deveriaGerarUmaListaDeRespostaDtoVaziaAtravesDeUmApiDtoVazio() {
		ArrayList<Item> itemsvazio = new ArrayList<>();
		apidto = new ApiDto(itemsvazio);
	List<RespostaDto> lista = ConversorDeDto.converterJsonEmRespostDto(apidto);
	
	Assertions.assertTrue(lista.isEmpty());
	}
	
	

}
