package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.pedidoAt.model.domain.Revista;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;
import br.edu.infnet.pedidoAt.model.service.RevistaService;

@Controller
public class RevistaController {
	
	@Autowired
	private RevistaService revistaService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/revistas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("revistaLista", revistaService.obterLista(usuario));
		
		return "revista/lista";
	}

	@GetMapping(value = "/revista")
	public String telaCadastro() {
		return "revista/cadastro";
	}

	@PostMapping(value = "/revista/incluir")
	public String incluir(Model model, Revista revista, @SessionAttribute("user") Usuario usuario) {

		revista.setUsuario(usuario);
		publicacaoService.incluir(revista);
		model.addAttribute("mensagem", "A revista " + revista.getTitulo() + " foi incluída com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/revista/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Revista revista = (Revista) publicacaoService.obterPorId(id);
		
		if(revista != null) {
			try {
				publicacaoService.excluir(id);				
				model.addAttribute("mensagem", "A revista "+revista.getTitulo()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A revista "+revista.getTitulo()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Revista inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}
