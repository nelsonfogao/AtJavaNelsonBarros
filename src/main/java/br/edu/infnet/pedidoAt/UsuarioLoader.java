package br.edu.infnet.pedidoAt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.pedidoAt.model.domain.Endereco;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String email = "nelson.barros@gmail.com";
		String senha = "123";
		
		Usuario usuario = null;
		
		usuario = usuarioService.autenticacao(email, senha);

		if(usuario == null) {
			Endereco endereco = new Endereco();
			endereco.setBairro("Inhauma");
			endereco.setCep("20760560");
			endereco.setComplemento("apt 201");
			endereco.setLocalidade("Rio de Janeiro");
			endereco.setLogradouro("Tavessa Eduardo das neves");
			endereco.setUf("RJ");
			
			usuario = new Usuario();
			usuario.setNome("Nelson Barros");
			usuario.setEmail("nelson.barros@gmail.com");
			usuario.setSenha("123");
			usuario.setAdmin(true);
			
			usuario.setEndereco(endereco);
	
			usuarioService.incluir(usuario);
		}
	}
}
