package br.edu.infnet.pedidoAt.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.edu.infnet.pedidoAt.exceptions.LeitorInexistenteException;

@Entity
@Table(name = "TPedido", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "descricao", "idLeitor" }) 
	}
)
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idLeitor")	
	private Leitor leitor;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Publicacao> publicacoes;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	

	public Pedido() {
		this.descricao = "Pedido padrão da empresa";
		this.data = LocalDateTime.now();
	}
	
	public Pedido(Leitor leitor) throws LeitorInexistenteException {
		this();
		
		if(leitor == null) {
			throw new LeitorInexistenteException("Impossível realizar o pedido sem um leitor associado!");
		}
		
		this.leitor = leitor;
	}
	

	public float calcularValorTotalPedido() {
		
		float valorTotal = 0;
		
		for(Publicacao item : publicacoes) {
			valorTotal = valorTotal + item.calcularValor();
		}
		
		return valorTotal;
	}
	
	public String obterLinhaGravacaoArquivo() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(descricao);
		sb.append(";");
		sb.append(leitor.getNome());
		sb.append(";");
		sb.append(publicacoes.size());
		sb.append(";");
		sb.append(calcularValorTotalPedido());
		sb.append("\r\n");
		
		return sb.toString();
	}

	public void impressao() {
	

		System.out.println("Relatório de Pedido:");
		System.out.println(this);
		System.out.println("#Produtos");
		for(Publicacao item : publicacoes) {
			System.out.println("- " + item);
		}
	}
	
	@Override
	public String toString() {
		
		int qtdePublicacoes = publicacoes != null ? publicacoes.size() : 0;

		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s;%s;%s;%d,%.2f", 
				this.descricao,
				this.data.format(formatacao),
				this.leitor,
				qtdePublicacoes,
				this.calcularValorTotalPedido()
			);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public Leitor getLeitor() {
		return leitor;
	}


	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}


	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}


	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}
