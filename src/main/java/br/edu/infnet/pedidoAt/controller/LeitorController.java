package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.pedidoAt.model.domain.Leitor;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.LeitorService;

@Controller
public class LeitorController {
	
	@Autowired
	private LeitorService leitorService;

	@GetMapping(value = "/leitor")
	public String telaCadastro() {
		return "leitor/cadastro";
	}
	
	@GetMapping(value = "/leitores")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("leitorLista", leitorService.obterLista(usuario));

		return "leitor/lista";
	}

	@PostMapping(value = "/leitor/incluir")
	public String incluir(Leitor leitor, Model model, @SessionAttribute("user") Usuario usuario){
		
		leitor.setUsuario(usuario);

		leitorService.incluir(leitor);

		model.addAttribute("mensagem", "O leitor " + leitor.getNome() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/leitor/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Leitor leitor = leitorService.obterPorId(id);
				
		if(leitor != null) {
			try {
				leitorService.excluir(id);				
				model.addAttribute("mensagem", "O leitor "+leitor.getNome()+" foi excluído com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! O leitor "+leitor.getNome()+" está associado a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Leitor inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}
