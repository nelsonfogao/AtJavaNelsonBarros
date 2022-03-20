package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class PublicacaoController {
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@GetMapping(value = "/publicacoes")
	public String telaLista(Model model) {

		model.addAttribute("publicacaoLista", publicacaoService.obterLista());
		
		return "publicacao/lista";
	}

	@GetMapping(value = "/publicacao/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		publicacaoService.excluir(id);
		
		return "redirect:/publicacoes";
	}
}
