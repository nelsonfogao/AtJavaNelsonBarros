package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.MangaService;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class MangaController {
	
	@Autowired
	private MangaService mangaService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/mangas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("mangaLista", mangaService.obterLista(usuario));
		
		return "manga/lista";
	}

	@GetMapping(value = "/manga")
	public String telaCadastro() {
		return "manga/cadastro";
	}

	@PostMapping(value = "/manga/incluir")
	public String incluir(Model model, Manga manga, @SessionAttribute("user") Usuario usuario) {

		manga.setUsuario(usuario);
		publicacaoService.incluir(manga);
		model.addAttribute("mensagem", "O Manga " + manga.getTitulo() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/manga/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Manga manga = (Manga) publicacaoService.obterPorId(id);
		
		if(manga != null) {
			try {
				publicacaoService.excluir(id);				
				model.addAttribute("mensagem", "O Manga "+manga.getTitulo()+" foi excluído com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! O Manga "+manga.getTitulo()+" está associado a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Manga inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}
