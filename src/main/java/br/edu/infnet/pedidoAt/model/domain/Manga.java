package br.edu.infnet.pedidoAt.model.domain;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;

public class Manga extends Publicacao{
	private int volume;
	private String autor;
	private String categoria;
	private boolean adulto;
	
	public Manga(String descricao, float valor, String editora) throws ValorInvalidoException, EditoraInvalidaException {
		super(descricao, valor, editora);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(volume);
		sb.append(";");
		sb.append(autor);
		sb.append(";");
		sb.append(categoria);
		sb.append(";");
		sb.append(adulto ? "adulto" : "infantil");	
		return sb.toString();
	}

	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isAdulto() {
		return adulto;
	}


	public void setAdulto(boolean adulto) {
		this.adulto = adulto;
	}


}
