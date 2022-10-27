package br.com.paulo25.EncLivro.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.paulo25.EncLivro.model.dto.ApiDto;
import br.com.paulo25.EncLivro.model.dto.FormPesquisa;
import br.com.paulo25.EncLivro.model.dto.RespostaDto;
import br.com.paulo25.EncLivro.model.dto.TipoPesquisa;
import br.com.paulo25.EncLivro.service.ApiBookService;
import br.com.paulo25.EncLivro.util.ConversorDeDto;

@Controller
@RequestMapping("livro")
public class LivroController {
	
	@Autowired
	private ApiBookService abs;

	@GetMapping("form")
	public String formulario(Model m) {
		
		m.addAttribute("form", new FormPesquisa());
		m.addAttribute("tipos",TipoPesquisa.popularLista());
		return "pesquisa/form";
	}

	@PostMapping("consultar")
	public ModelAndView pesquisar(@Valid FormPesquisa form, BindingResult br) {
        System.out.println(form.getTipopesquisa().getValue());
		ModelAndView mv;

		if (br.hasErrors()) {
			mv = new ModelAndView("pesquisa/form");
			return mv;
		}

		ApiDto livros = abs.consumir(form);
		List<RespostaDto> listaLivros = ConversorDeDto.converterJsonEmRespostDto(livros);
		mv = new ModelAndView("pesquisa/resultado");
		mv.addObject("livros", listaLivros);
		listaLivros.forEach(l -> System.out.println(l.getDatapublicacao()));
		return mv;

	}

}
