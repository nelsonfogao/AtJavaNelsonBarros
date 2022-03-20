package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.service.LivroService;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/livros")
	public String telaLista(Model model) {

		model.addAttribute("livroLista", livroService.obterLista());
		
		return "livro/lista";
	}

	@GetMapping(value = "/livro")
	public String telaCadastro() {
		return "livro/cadastro";
	}

	@PostMapping(value = "/livro/incluir")
	public String incluir(Livro livro) {

		publicacaoService.incluir(livro);
		
		return "redirect:/livros";
	}

	@GetMapping(value = "/livro/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		publicacaoService.excluir(id);
		
		return "redirect:/livros";
	}
}
