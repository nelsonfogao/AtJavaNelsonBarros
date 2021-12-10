package br.edu.infnet.pedidoAt.model.domain;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;

public class Revista extends Publicacao{
	
	private String periodicidade;
	private boolean impressa;
	private boolean adulta;

	public Revista(String descricao, float valor, String editora) throws ValorInvalidoException, EditoraInvalidaException {
		super(descricao, valor, editora);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(periodicidade);
		sb.append(";");
		sb.append(impressa ? "impressa" : "online");
		sb.append(";");
		sb.append(adulta ? "adulta" : "infantil");
		return sb.toString();
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}
	
	public boolean ehImpressa() {
		return impressa;
	}

	public void setImpressa(boolean impressa) {
		this.impressa = impressa;
	}
	
	public boolean ehAdulta() {
		return adulta;
	}

	public void setAdulta(boolean adulta) {
		this.adulta = adulta;
	}
}
