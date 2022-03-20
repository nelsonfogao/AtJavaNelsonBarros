package br.edu.infnet.pedidoAt.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;





@Entity
@Table(name = "TLivro")
public class Livro extends Publicacao{

	private String ISBN;
	private String autor;
	private int edicao;
	private String categoria;
	private boolean importado;

	
	public Livro() {
		
	}
	
	public Livro(String titulo, float valor, String editora) throws ValorInvalidoException, EditoraInvalidaException {
		super(titulo, valor, editora);
	}
	


	@Override
	public float calcularValor() {
	
		return this.getValor() 
				+ (importado ? this.getValor() : 0);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(ISBN);
		sb.append(";");
		sb.append(edicao);
		sb.append(";");
		sb.append(autor);
		sb.append(";");
		sb.append(categoria);	
		sb.append(";");
		sb.append(importado ? "importado" : "nacional");
		return sb.toString();
	}

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isImportado() {
		return importado;
	}
	public void setImportado(boolean importado) {
		this.importado = importado;
	}
}
