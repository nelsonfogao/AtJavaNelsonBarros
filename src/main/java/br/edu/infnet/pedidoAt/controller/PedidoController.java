package br.edu.infnet.pedidoAt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.pedidoAt.model.domain.Pedido;
import br.edu.infnet.pedidoAt.model.domain.Publicacao;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.LeitorService;
import br.edu.infnet.pedidoAt.model.service.PedidoService;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private LeitorService leitorService;
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("leitorLista", leitorService.obterLista(usuario));
		
		model.addAttribute("publicacaoLista", publicacaoService.obterLista(usuario));

		return "pedido/cadastro";
	}
	
	@GetMapping(value = "/pedidos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("pedidoLista", pedidoService.obterLista(usuario));

		return "pedido/lista";
	}

	@PostMapping(value = "/pedido/incluir")
	public String incluir(@RequestParam String[] idsPublicacoes, Pedido pedido, Model model, @SessionAttribute("user") Usuario usuario){
		
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		
		for(String idPublicacao : idsPublicacoes) {
			
			Publicacao publicacao = publicacaoService.obterPorId(Integer.valueOf(idPublicacao));
			
			publicacoes.add(publicacao);
		}
		
		pedido.setUsuario(usuario);
		
		pedido.setPublicacoes(publicacoes);

		pedidoService.incluir(pedido);

		model.addAttribute("mensagem", "O pedido " + pedido.getDescricao() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Pedido pedido = pedidoService.obterPorId(id);
				
		if(pedido != null) {			
			pedidoService.excluir(id);			
			model.addAttribute("mensagem", "O pedido "+pedido.getDescricao()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Pedido inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}
