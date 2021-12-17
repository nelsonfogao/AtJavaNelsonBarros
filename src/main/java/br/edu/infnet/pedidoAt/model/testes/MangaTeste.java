package br.edu.infnet.pedidoAt.model.testes;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Manga;

public class MangaTeste {
	public static void main(String[] args) {

		try {
			Manga naruto = new Manga("Naruto", 10, "Panini");
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Infantil");
			naruto.setAdulto(false);
			System.out.println("Valor de venda: " + naruto.getValor());	
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Manga naruto = new Manga("Naruto", -1, "Panini");
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Infantil");
			naruto.setAdulto(false);
			System.out.println("Valor de venda: " + naruto.getValor());	
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Manga naruto = new Manga("Naruto", 10, "");
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Infantil");
			naruto.setAdulto(false);
			System.out.println("Valor de venda: " + naruto.getValor());	
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Manga naruto = new Manga("Naruto", 10, null);
			naruto.setVolume(1);
			naruto.setAutor("Masashi Kishimoto");
			naruto.setCategoria("Infantil");
			naruto.setAdulto(false);
			System.out.println("Valor de venda: " + naruto.getValor());	
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Manga bleach = new Manga("Bleach", 15, "Panini");
			bleach.setVolume(10);
			bleach.setAutor("Tite Kubo");
			bleach.setCategoria("Infantil");
			bleach.setAdulto(false);
			System.out.println("Valor de venda: " + bleach.getValor());	
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Manga parasyte = new Manga("Parasyte", 9, "JBC");
			parasyte.setVolume(10);
			parasyte.setAutor("Hitoshi Iwaaki");
			parasyte.setCategoria("Terror");
			parasyte.setAdulto(true);
			System.out.println("Valor de venda: " + parasyte.getValor());	
		} catch (ValorInvalidoException | EditoraInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
