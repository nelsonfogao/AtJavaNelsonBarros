package br.edu.infnet.pedidoAt.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.pedidoAt.exceptions.LeitorInexistenteException;
import br.edu.infnet.pedidoAt.exceptions.PedidoSemPublicacoesException;

public class Pedido {
	
	private String descricao;
	private LocalDateTime data;
	private Leitor leitor;
	private List<Publicacao> publicacoes;
	
	public Pedido(Leitor leitor) throws LeitorInexistenteException {
		
		if(leitor == null) {
			throw new LeitorInexistenteException("Impossível realizar o pedido sem um leitor associado!");
		}
		
		this.descricao = "Pedido padrão";
		this.data = LocalDateTime.now();
		this.leitor = leitor;
	}
	
	public float calcularValorTotalPedido() {
		
		float valorTotal = 0;
		
		for(Publicacao item : publicacoes) {
			valorTotal = valorTotal + item.getValor();
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

	public void impressao() throws PedidoSemPublicacoesException {
		
		if(publicacoes == null || publicacoes.size() <= 0) {
			throw new PedidoSemPublicacoesException("Não existem produtos associados!!!");
		}

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

	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getData() {
		return data;
	}
	public Leitor getLeitor() {
		return leitor;
	}
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}

}
