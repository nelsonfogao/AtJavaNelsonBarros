package br.edu.infnet.pedidoAt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.pedidoAt.model.domain.Leitor;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.LeitorService;

@Order(2)
@Component
public class LeitorLoader implements ApplicationRunner {
	
	@Autowired
	private LeitorService leitorService;

	@Override
	public void run(ApplicationArguments args) {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Leitor leitor = new Leitor("Maria", "maria@gmail.com", "12365478549");
			leitor.setUsuario(usuario);
			
			leitorService.incluir(leitor);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}
