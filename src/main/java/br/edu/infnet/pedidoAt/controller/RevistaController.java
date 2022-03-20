package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.pedidoAt.model.domain.Revista;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;
import br.edu.infnet.pedidoAt.model.service.RevistaService;

@Controller
public class RevistaController {
	
	@Autowired
	private RevistaService revistaService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/revistas")
	public String telaLista(Model model) {

		model.addAttribute("revistaLista", revistaService.obterLista());
		
		return "revista/lista";
	}

	@GetMapping(value = "/revista")
	public String telaCadastro() {
		return "revista/cadastro";
	}

	@PostMapping(value = "/revista/incluir")
	public String incluir(Revista revista) {

		publicacaoService.incluir(revista);
		
		return "redirect:/revistas";
	}

	@GetMapping(value = "/revista/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		publicacaoService.excluir(id);
		
		return "redirect:/revistas";
	}
}
