package br.edu.infnet.pedidoAt.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;



@Entity
@Table(name = "TManga")
public class Manga extends Publicacao{
	private int volume;
	private String autor;
	private String categoria;
	private boolean adulto;
	
	
	public Manga() {
		
	}

	public Manga(String titulo, float valor, String editora) throws ValorInvalidoException, EditoraInvalidaException {
		super(titulo, valor, editora);
	}
	
	@Override
	public float calcularValor() {
	
		return this.getValor() 
				+ (adulto ? this.getValor() : 0);
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
