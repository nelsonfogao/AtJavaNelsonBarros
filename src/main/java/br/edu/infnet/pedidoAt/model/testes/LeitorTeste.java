package br.edu.infnet.pedidoAt.model.testes;

import br.edu.infnet.pedidoAt.exceptions.CpfInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.EmailInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.NomeInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Leitor;

public class LeitorTeste {
	
	public static void main(String[] args) {
		
		try {
			Leitor leitor = new Leitor("Elberth", "elberth@elberth", "123.456.789-12");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Leitor leitor = new Leitor(null, "elberth@elberth", "123.456.789-12");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Leitor leitor = new Leitor("Elberth", "elberth@elberth", "123.456.789-12");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Leitor leitor = new Leitor("Elberth", null, "123.456.789-12");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Leitor leitor = new Leitor("Elberth", "elberth@elberth", "123.456.789-12");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Leitor leitor = new Leitor("Elberth", "elberth@elberth", null);
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

}
