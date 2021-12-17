package br.edu.infnet.pedidoAt.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.CpfInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.EmailInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.LeitorInexistenteException;
import br.edu.infnet.pedidoAt.exceptions.NomeInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.PedidoSemPublicacoesException;
import br.edu.infnet.pedidoAt.exceptions.PeriodicidadeInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Leitor;
import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Pedido;
import br.edu.infnet.pedidoAt.model.domain.Publicacao;
import br.edu.infnet.pedidoAt.model.domain.Revista;

public class PedidoTeste {

public static void main(String[] args) {
		
		List<Publicacao> listagemPublicacao = new ArrayList<Publicacao>();

		try {
			Livro harryPotter = new Livro("HarryPotter", 49, "Rocco");
			harryPotter.setISBN("9780590353403");
			harryPotter.setEdicao(1);
			harryPotter.setAutor("J.K. Rolling");
			harryPotter.setCategoria("Infanto-Juvenil");
			harryPotter.setImportado(true);
			listagemPublicacao.add(harryPotter);
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Revista caras = new Revista("Caras", 10, "Caras");
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			listagemPublicacao.add(caras);
		} catch (ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista caras = new Revista("Caras", 10, "Caras");
			caras.setPeriodicidade("");
			caras.setImpressa(true);
			caras.setAdulta(false);
			listagemPublicacao.add(caras);
		} catch (ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Manga naruto = new Manga("Naruto", 10, "Panini");
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Shonen");
			naruto.setAdulto(false);
			listagemPublicacao.add(naruto);
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}

		Leitor leitor = null;
		try {
			leitor = new Leitor("Nelson", "nelson.hotmail.com", "05881368754");
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}		

		try {
			Pedido pedido = new Pedido(leitor);
			pedido.setDescricao("Pedido do nelson");
			pedido.setPublicacoes(listagemPublicacao);
			pedido.impressao();
		} catch (PedidoSemPublicacoesException | LeitorInexistenteException e) {
			System.out.println(e.getMessage());
		}

	}
}
