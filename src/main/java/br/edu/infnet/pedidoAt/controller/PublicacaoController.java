package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Publicacao;
import br.edu.infnet.pedidoAt.model.domain.Revista;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class PublicacaoController {
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@GetMapping(value = "/publicacoes")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("publicacaoLista", publicacaoService.obterLista(usuario));
		
		return "publicacao/lista";
	}

	@GetMapping(value = "/publicacao/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Publicacao publicacao = publicacaoService.obterPorId(id);
		
		String tipoPublicacao = obterTipoPublicacao(publicacao);
		
		if(publicacao != null) {
			try {
				publicacaoService.excluir(id);				
				model.addAttribute("mensagem", "A "+tipoPublicacao+" "+publicacao.getTitulo()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A "+tipoPublicacao+" "+publicacao.getTitulo()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Publicacao inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
	
	private String obterTipoPublicacao(Publicacao publicacao) {
		String tipoPublicacao = null;
		
		if(publicacao instanceof Revista) {
			tipoPublicacao = "revista";
		}else if (publicacao instanceof Manga) {
			tipoPublicacao = "manga";
		}else {
			tipoPublicacao = "livro";
		}
		
		return tipoPublicacao;
	}
}
