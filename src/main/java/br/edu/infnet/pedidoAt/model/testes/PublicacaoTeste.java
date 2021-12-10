package br.edu.infnet.pedidoAt.model.testes;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Revista;

public class PublicacaoTeste {

	public static void main(String[] args) {

		try {
			Livro harryPotter = new Livro("Harry Potter", 49, "Rocco");
			harryPotter.setISBN("9780590353403");
			harryPotter.setEdicao(1);
			harryPotter.setAutor("J.K. Rolling");
			harryPotter.setCategoria("Infanto-Juvenil");
			harryPotter.setImportado(true);
			System.out.println(harryPotter);
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Revista caras = new Revista("Caras", 10, "Caras");
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			System.out.println(caras);
		} catch ( ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Manga naruto = new Manga("Naruto", 10, "Panini");
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Infantil");
			naruto.setAdulto(false);
			System.out.println(naruto);
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}
