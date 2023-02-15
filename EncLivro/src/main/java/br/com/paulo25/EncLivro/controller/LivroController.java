package br.com.paulo25.EncLivro.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.paulo25.EncLivro.model.ApiDto;
import br.com.paulo25.EncLivro.model.Dto.FormPesquisa;
import br.com.paulo25.EncLivro.model.Dto.RespostaDto;
import br.com.paulo25.EncLivro.model.Dto.TipoPesquisa;
import br.com.paulo25.EncLivro.service.ApiBookService;
import br.com.paulo25.EncLivro.util.ConversorDeDto;

@Controller
@RequestMapping("livro")
public class LivroController {
	
	@Autowired
	private ApiBookService abs;

	@GetMapping("form")
	public String formulario(Model m) {
		
		m.addAttribute("form",new FormPesquisa());
		m.addAttribute("tipos",TipoPesquisa.popularLista());
		return "pesquisa/form";
	}

	@PostMapping("consultar")
	public String pesquisar(@Valid @ModelAttribute("form") FormPesquisa form, BindingResult br,Model m) {
     
	

		if (br.hasErrors()) {
			m.addAttribute("tipos",TipoPesquisa.popularLista());
			return "pesquisa/form";
		}

		ApiDto livros = abs.consumir(form);
		List<RespostaDto> listaLivros = ConversorDeDto.converterJsonEmRespostDto(livros);
		
		if(listaLivros.isEmpty()) {
			m.addAttribute("msgListaVazia","Nenhum livro achado,utilize termos melhores");
		}
		m.addAttribute("livros", listaLivros);

		return "pesquisa/resultado";

	}
	
	@GetMapping("novaPesquisa")
public String novaPesquisa() {
		return "redirect:form";
}

}
