package br.edu.infnet.pedidoAt.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;



@Entity
@Table(name = "TRevista")
public class Revista extends Publicacao{
	
	
	private String periodicidade;
	private boolean impressa;
	private boolean adulta;

	
	public Revista() {
	}

	public Revista(String titulo, float valor, String editora) throws ValorInvalidoException, EditoraInvalidaException {
		super(titulo, valor, editora);
	}
	
	@Override
	public float calcularValor() {
	
		return this.getValor() 
				+ (adulta ? this.getValor() : 0);
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
	
	public boolean isImpressa() {
		return impressa;
	}

	public void setImpressa(boolean impressa) {
		this.impressa = impressa;
	}
	
	public boolean isAdulta() {
		return adulta;
	}

	public void setAdulta(boolean adulta) {
		this.adulta = adulta;
	}
	
	public void setPeriodicidade(String periodicidade){

		
		this.periodicidade = periodicidade;
	}
}
