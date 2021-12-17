package br.edu.infnet.pedidoAt.model.testes;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.PeriodicidadeInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Revista;

public class RevistaTeste {

	public static void main(String[] args) {
		
		try {
			Revista caras = new Revista("Caras", 10, "Caras");
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			System.out.println("Valor de venda: " + caras.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista caras = new Revista("Caras", 10, "");
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			System.out.println("Valor de venda: " + caras.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista caras = new Revista("Caras", 10, null);
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			System.out.println("Valor de venda: " + caras.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista caras = new Revista("Caras", -1, "Caras");
			caras.setPeriodicidade("Semanal");
			caras.setImpressa(true);
			caras.setAdulta(false);
			System.out.println("Valor de venda: " + caras.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista playboy = new Revista("Playboy", 20, "Abril");
			playboy.setPeriodicidade("Mensal");
			playboy.setImpressa(true);
			playboy.setAdulta(true);
			System.out.println("Valor de venda: " + playboy.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista recreio = new Revista("Recreio", 15, "Abril");
			recreio.setPeriodicidade("Mensal");
			recreio.setImpressa(true);
			recreio.setAdulta(false);
			System.out.println("Valor de venda: " + recreio.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Revista recreio = new Revista("Recreio", 15, "Abril");
			recreio.setPeriodicidade("");
			recreio.setImpressa(true);
			recreio.setAdulta(false);
			System.out.println("Valor de venda: " + recreio.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Revista recreio = new Revista("Recreio", 15, "Abril");
			recreio.setPeriodicidade(null);
			recreio.setImpressa(true);
			recreio.setAdulta(false);
			System.out.println("Valor de venda: " + recreio.getValor());
		} catch ( ValorInvalidoException | EditoraInvalidaException | PeriodicidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}
