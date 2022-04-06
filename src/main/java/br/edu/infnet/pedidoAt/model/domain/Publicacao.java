package br.edu.infnet.pedidoAt.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;



@Entity
@Table(name = "TPublicacao", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "titulo", "valor", "editora" }) 
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publicacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private float valor;
	private String editora;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "publicacoes")
	private List<Pedido> pedidos;
	
	public Publicacao() {
		
	}

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
		sb.append(id);
		sb.append(";");
		sb.append(titulo);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(editora);
		sb.append(";");
		
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
