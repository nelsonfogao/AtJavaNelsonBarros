package br.edu.infnet.pedidoAt.model.testes;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Livro;

public class LivroTeste {
	
	public static void main(String[] args) {

		try {
			Livro harryPotter = new Livro("Harry Potter", 49, "Rocco");
			harryPotter.setISBN("9780590353403");
			harryPotter.setAutor("J.K Rolling");
			harryPotter.setEdicao(1);
			harryPotter.setCategoria("Infanto-Juvenil");
			harryPotter.setImportado(true);
			System.out.println("Valor de venda: " + harryPotter.getValor());
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Livro percyJackson = new Livro("Percy Jackson", 29, "Casa das Letras");
			percyJackson.setISBN("9788580575392");
			percyJackson.setAutor("Rick Riordan");
			percyJackson.setEdicao(2);
			percyJackson.setCategoria("Infanto-Juvenil");
			percyJackson.setImportado(true);
			System.out.println("Valor de venda: " + percyJackson.getValor());
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Livro alquimista = new Livro("O Alquimista", 15, "Companhia das Letras");
			alquimista.setISBN("9788584390670");
			alquimista.setAutor("Paulo Coelho");
			alquimista.setEdicao(5);
			alquimista.setCategoria("Romance");
			alquimista.setImportado(false);
			System.out.println("Valor de venda: " + alquimista.getValor());
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}
