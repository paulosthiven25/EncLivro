package br.com.paulo25.EncLivro.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoPesquisa {
AUTOR("inauthor"),
TITULO("intitle");

private final String value;

private TipoPesquisa(String value) {
    this.value = value;
}

public String getValue() { return value; }

public static List<String> popularLista() {
	List<String> tipos = new ArrayList<String>();
	Arrays.asList(TipoPesquisa.values()).forEach(tipo -> tipos.add(tipo.toString()));
	return tipos;
}



}
