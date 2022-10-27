package br.com.paulo25.EncLivro.util;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatadoraDeStringsDeDatasTest {
	
	private String dataCompleta;
	private String dataMesAno;
	private String ano;
	
	@BeforeEach
		public void inicializar() {
		dataCompleta = "2000-01-25";
		dataMesAno = "2000-01";
		ano  = "2000";
	}
	
	
	@Test
	public void deveriaFormatarUmaStringValidaParaUmaDatavalidaNoBrasil () {
		
		Assertions.assertEquals("25/01/2000",FormatadoraDeStringsDeDatas.converterDatasString(dataCompleta));
		Assertions.assertEquals("01/2000",FormatadoraDeStringsDeDatas.converterDatasString(dataMesAno));
		Assertions.assertEquals("2000",FormatadoraDeStringsDeDatas.converterDatasString(ano));
	}
	
	
	

	@Test
	public void naoDeveriaFormatarUmaStringInvalidaParaUmaDatavalidaNoBrasil() {
		
		Assertions.assertEquals("data não disponível",FormatadoraDeStringsDeDatas.converterDatasString("99999"));
		
		
	
	}

}
