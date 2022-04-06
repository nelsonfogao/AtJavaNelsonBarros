package br.edu.infnet.pedidoAt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.pedidoAt.model.domain.Leitor;
import br.edu.infnet.pedidoAt.model.domain.Pedido;
import br.edu.infnet.pedidoAt.model.domain.Publicacao;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.PedidoService;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Order(4)
@Component
public class PedidoLoader implements ApplicationRunner {
	
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private PedidoService pedidoService;

	@Override
	public void run(ApplicationArguments args) {
		try {
			List<Publicacao> publicacoes = new ArrayList<Publicacao>(
						publicacaoService.obterLista()
					);
	
			Leitor leitor = new Leitor();
			leitor.setId(1);
			
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Pedido pedido = new Pedido(leitor);
			pedido.setDescricao("Pedido numero 1");
			pedido.setPublicacoes(publicacoes);
			pedido.setUsuario(usuario);
			
			pedidoService.incluir(pedido);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}
