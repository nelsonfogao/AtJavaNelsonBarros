package br.edu.infnet.pedidoAt.model.testes;

import br.edu.infnet.pedidoAt.exceptions.CpfInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.EmailInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.NomeInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Leitor;

public class LeitorTeste {
	
	public static void main(String[] args) {
		
		try {
			Leitor leitor = new Leitor("Nelson", "nelson.barros@al.infnet.edu.br", "058.813.687-54");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Leitor leitor = new Leitor(null, "nelson.barros@al.infnet.edu.br", "058.813.687-54");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Leitor leitor = new Leitor("Nelson", null, "058.813.687-54");
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Leitor leitor = new Leitor("Nelson", "nelson.barros@al.infnet.edu.br", null);
			System.out.println(leitor);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

}
