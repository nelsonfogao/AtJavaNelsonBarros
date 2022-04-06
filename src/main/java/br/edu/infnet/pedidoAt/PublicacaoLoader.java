package br.edu.infnet.pedidoAt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Revista;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.PublicacaoService;

@Order(3)
@Component
public class PublicacaoLoader implements ApplicationRunner {

	@Autowired
	private PublicacaoService publicacaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);
			
			Livro harryPotter = new Livro("HarryPotter", 49, "Rocco");
			harryPotter.setISBN("9780590353403");
			harryPotter.setEdicao(1);
			harryPotter.setAutor("J.K. Rolling");
			harryPotter.setCategoria("Infanto-Juvenil");
			harryPotter.setImportado(true);
			harryPotter.setUsuario(usuario);
			publicacaoService.incluir(harryPotter);
			
			Revista caras = new Revista("Caras", 10, "Caras");
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			caras.setUsuario(usuario);
			publicacaoService.incluir(caras);
			
			Manga naruto = new Manga("Naruto", 10, "Panini");
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Shonen");
			naruto.setAdulto(false);
			naruto.setUsuario(usuario);
			publicacaoService.incluir(naruto);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}
