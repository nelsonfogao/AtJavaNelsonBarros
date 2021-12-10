package br.edu.infnet.pedidoAt.exceptions;

public class LeitorInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public LeitorInexistenteException(String mensagem) {
		super(mensagem);
	}
}
