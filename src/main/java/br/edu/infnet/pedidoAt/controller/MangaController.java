package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.service.MangaService;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class MangaController {
	
	@Autowired
	private MangaService mangaService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/mangas")
	public String telaLista(Model model) {

		model.addAttribute("mangaLista", mangaService.obterLista());
		
		return "manga/lista";
	}

	@GetMapping(value = "/manga")
	public String telaCadastro() {
		return "manga/cadastro";
	}

	@PostMapping(value = "/manga/incluir")
	public String incluir(Manga manga) {

		publicacaoService.incluir(manga);
		
		return "redirect:/mangas";
	}

	@GetMapping(value = "/manga/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		publicacaoService.excluir(id);
		
		return "redirect:/mangas";
	}
}
