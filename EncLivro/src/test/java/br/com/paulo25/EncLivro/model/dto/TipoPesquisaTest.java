package br.com.paulo25.EncLivro.model.dto;





import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.paulo25.EncLivro.model.Dto.TipoPesquisa;


class TipoPesquisaTest {
	
	 

	@Test
	public void deveriaPopularUmaListaComTodosOsValoresPossiveisdoEnumTipoPesquisa() {
		Assertions.assertEquals(2,TipoPesquisa.popularLista().size());
	}

	@Test
	public void naodeveriaPopularUmaListaComTodosOsValoresPossiveisdoEnumTipoPesquisa() {
		Assertions.assertNotEquals(0,TipoPesquisa.popularLista().size());
	}
}
