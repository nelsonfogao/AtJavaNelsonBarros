package br.edu.infnet.pedidoAt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.LivroService;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/livros")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("livroLista", livroService.obterLista(usuario));
		
		return "livro/lista";
	}

	@GetMapping(value = "/livro")
	public String telaCadastro() {
		return "livro/cadastro";
	}

	@PostMapping(value = "/livro/incluir")
	public String incluir(Model model, Livro livro, @SessionAttribute("user") Usuario usuario) {

		livro.setUsuario(usuario);
		publicacaoService.incluir(livro);
		
		model.addAttribute("mensagem", "O Livro " + livro.getTitulo() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/livro/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Livro livro = (Livro) publicacaoService.obterPorId(id);
		
		if(livro != null) {
			try {
				publicacaoService.excluir(id);				
				model.addAttribute("mensagem", "O Livro "+livro.getTitulo()+" foi excluído com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! O Livro "+livro.getTitulo()+" está associado a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Livro inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}
