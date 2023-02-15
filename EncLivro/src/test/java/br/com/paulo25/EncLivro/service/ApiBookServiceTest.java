package br.com.paulo25.EncLivro.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.paulo25.EncLivro.model.ApiDto;
import br.com.paulo25.EncLivro.model.ImageLinks;
import br.com.paulo25.EncLivro.model.Item;
import br.com.paulo25.EncLivro.model.VolumeInfo;
import br.com.paulo25.EncLivro.model.Dto.FormPesquisa;
import br.com.paulo25.EncLivro.model.Dto.TipoPesquisa;

class ApiBookServiceTest {
	
	@InjectMocks
	private ApiBookService abs;
	@Mock
	private GerenciadorRequisiçãoBase grb;
	@Mock
	private ObjectMapper om;
	
	private String jsonFake;
	
	
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        jsonFake = "{\n"
				+ "    \"kind\": \"books#volumes\",\n"
				+ "    \"totalItems\": 200,\n"
				+ "    \"items\": [\n"
				+ "        {\n"
				+ "            \"kind\": \"books#volume\",\n"
				+ "            \"id\": \"_DJAzwEACAAJ\",\n"
				+ "            \"etag\": \"zK5zntxTMGQ\",\n"
				+ "            \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/_DJAzwEACAAJ\",\n"
				+ "            \"volumeInfo\": {\n"
				+ "                \"title\": \"H. P. Lovecraft: Medo Classico Volume 1\",\n"
				+ "                \"authors\": [\n"
				+ "                    \"Howard Phillips Lovecraft\"\n"
				+ "                ],\n"
				+ "                \"publishedDate\": \"2017\",\n"
				+ "                \"industryIdentifiers\": [\n"
				+ "                    {\n"
				+ "                        \"type\": \"ISBN_10\",\n"
				+ "                        \"identifier\": \"8594540795\"\n"
				+ "                    },\n"
				+ "                    {\n"
				+ "                        \"type\": \"ISBN_13\",\n"
				+ "                        \"identifier\": \"9788594540799\"\n"
				+ "                    }\n"
				+ "                ],\n"
				+ "                \"readingModes\": {\n"
				+ "                    \"text\": false,\n"
				+ "                    \"image\": false\n"
				+ "                },\n"
				+ "                \"pageCount\": 395,\n"
				+ "                \"printType\": \"BOOK\",\n"
				+ "                \"maturityRating\": \"NOT_MATURE\",\n"
				+ "                \"allowAnonLogging\": false,\n"
				+ "                \"contentVersion\": \"preview-1.0.0\",\n"
				+ "                \"panelizationSummary\": {\n"
				+ "                    \"containsEpubBubbles\": false,\n"
				+ "                    \"containsImageBubbles\": false\n"
				+ "                },\n"
				+ "                \"language\": \"en\",\n"
				+ "                \"previewLink\": \"http://books.google.com.br/books?id=_DJAzwEACAAJ&dq=inauthor:Lovecraft&hl=&cd=1&source=gbs_api\",\n"
				+ "                \"infoLink\": \"http://books.google.com.br/books?id=_DJAzwEACAAJ&dq=inauthor:Lovecraft&hl=&source=gbs_api\",\n"
				+ "                \"canonicalVolumeLink\": \"https://books.google.com/books/about/H_P_Lovecraft_Medo_Classico_Volume_1.html?hl=&id=_DJAzwEACAAJ\"\n"
				+ "            },\n"
				+ "            \"saleInfo\": {\n"
				+ "                \"country\": \"BR\",\n"
				+ "                \"saleability\": \"NOT_FOR_SALE\",\n"
				+ "                \"isEbook\": false\n"
				+ "            },\n"
				+ "            \"accessInfo\": {\n"
				+ "                \"country\": \"BR\",\n"
				+ "                \"viewability\": \"NO_PAGES\",\n"
				+ "                \"embeddable\": false,\n"
				+ "                \"publicDomain\": false,\n"
				+ "                \"textToSpeechPermission\": \"ALLOWED\",\n"
				+ "                \"epub\": {\n"
				+ "                    \"isAvailable\": false\n"
				+ "                },\n"
				+ "                \"pdf\": {\n"
				+ "                    \"isAvailable\": false\n"
				+ "                },\n"
				+ "                \"webReaderLink\": \"http://play.google.com/books/reader?id=_DJAzwEACAAJ&hl=&printsec=frontcover&source=gbs_api\",\n"
				+ "                \"accessViewStatus\": \"NONE\",\n"
				+ "                \"quoteSharingAllowed\": false\n"
				+ "            }\n"
				+ "        }\n"
				+ "    ]\n"
				+ "}";
    }
	
	@Test
	void deveriaRetorarUmApiDtoComUmItemNaSuaListaDeItens() throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> responseFake = new ResponseEntity<String>(jsonFake,HttpStatus.OK);
		when(grb.consumirApi("Lovecraft","inauthor")).thenReturn(responseFake);
		ArrayList<String> autores = new ArrayList<>();
		autores.add("Howard Phillips Lovecraft");
		Item item  = new Item(new VolumeInfo("H. P. Lovecraft: Medo Classico Volume 1",autores, jsonFake,new ImageLinks()),"_DJAzwEACAAJ");
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item);
		ApiDto apidtoFake = new ApiDto(itens);
		when(om.readValue(jsonFake,ApiDto.class)).thenReturn(apidtoFake);
		ApiDto apidto = abs.consumir(new FormPesquisa("Lovecraft",TipoPesquisa.AUTOR));
		Assertions.assertEquals(apidtoFake.getItems().size(),apidto.getItems().size());
	}
	


}
