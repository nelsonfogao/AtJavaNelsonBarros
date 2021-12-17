package br.edu.infnet.pedidoAt.model.domain;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;

public abstract class Publicacao {

	private String titulo;
	private float valor;
	private String editora;
	
	public Publicacao(String titulo, float valor, String editora) throws ValorInvalidoException, EditoraInvalidaException {
		
		if(valor <= 0 ) {
			throw new ValorInvalidoException("Impossível realizar o cadastramento do produto " + titulo + " com o valor zerado ou negativo!");
		}

		if(editora == null || editora.isBlank()) {
			throw new EditoraInvalidaException("Impossível realizar o cadastramento do produto " + titulo + " com a editora inválida!");
		}
		
		this.titulo = titulo;
		this.valor = valor;
		this.editora = editora;
	}
	
	public abstract float calcularValor();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(editora);
		sb.append(";");
		
		return sb.toString();
	}

	public String getDescricao() {
		return titulo;
	}
	public float getValor() {
		return valor;
	}
	public String getEditora() {
		return editora;
	}
}
