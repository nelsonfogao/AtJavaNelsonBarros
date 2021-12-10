package br.edu.infnet.pedidoAt.model.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedidoAt.exceptions.EditoraInvalidaException;
import br.edu.infnet.pedidoAt.exceptions.CpfInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.EmailInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.LeitorInexistenteException;
import br.edu.infnet.pedidoAt.exceptions.NomeInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.PedidoSemPublicacoesException;
import br.edu.infnet.pedidoAt.exceptions.ValorInvalidoException;
import br.edu.infnet.pedidoAt.model.domain.Leitor;
import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Pedido;
import br.edu.infnet.pedidoAt.model.domain.Publicacao;
import br.edu.infnet.pedidoAt.model.domain.Revista;

public class ArquivoPedidoTeste {
	public static void main(String[] args) {
		try {
			
			List<String> inconsistencias = new ArrayList<String>();
			
			System.out.println("Início do processamento de pedidos!!!");
			try {
				
				String arquivo = "pedido.txt";
				
				FileReader fileR = new FileReader(arquivo);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_" + arquivo);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();
				
				String[] campos = null;
				
				List<Publicacao> publicacoes = new ArrayList<Publicacao>();
	
				Pedido pedido = null;
				
				while(linha != null) {
					campos = linha.split(";");
					
					String tipo = campos[0];
					
					switch (tipo.toUpperCase()) {
					case "P":
	
						Leitor leitor = null;
						try {
							leitor = new Leitor(campos[2], campos[3], campos[4]);
						} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
							System.out.println(e.getMessage());
						}		
	
						try {
							pedido = new Pedido(leitor);
							pedido.setDescricao(campos[1]);
							pedido.setPublicacoes(publicacoes);
							
						} catch (LeitorInexistenteException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case "L":				
						try {
							Livro harryPotter = new Livro(campos[1], Float.valueOf(campos[2]), (campos[3]));
							harryPotter.setISBN(campos[4]);
							harryPotter.setEdicao(Integer.valueOf((campos[5])));
							harryPotter.setAutor(campos[6]);
							harryPotter.setCategoria(campos[7]);
							harryPotter.setImportado(Boolean.valueOf(campos[8]));
							
							publicacoes.add(harryPotter);
						} catch (ValorInvalidoException | EditoraInvalidaException e) {
							System.out.println(e.getMessage());
						}
	
						break;
					case "R":				
						try {
							Revista caras = new Revista(campos[1], Float.valueOf(campos[2]), (campos[3]));
							
							caras.setPeriodicidade(campos[4]);
							caras.setImpressa(Boolean.valueOf(campos[5]));
							caras.setAdulta(Boolean.valueOf(campos[6]));
							publicacoes.add(caras);
						} catch (ValorInvalidoException | EditoraInvalidaException e) {
							System.out.println(e.getMessage());
						}
	
						break;
					case "M":				
						try {
							Manga naruto = new Manga(campos[1], Float.valueOf(campos[2]), (campos[3]));
							naruto.setVolume(Integer.valueOf((campos[4])));
							naruto.setAutor(campos[5]);
							naruto.setCategoria(campos[6]);
							naruto.setAdulto(Boolean.valueOf(campos[7]));
							publicacoes.add(naruto);
						} catch (ValorInvalidoException | EditoraInvalidaException e) {
							System.out.println(e.getMessage());
						}
	
						break;
	
					default:
						inconsistencias.add(linha);
						break;
					}
					
					linha = leitura.readLine();
				}
				
				try {
					pedido.impressao();
	
					escrita.write(pedido.obterLinhaGravacaoArquivo());		
					
					System.out.println("#Quantidade de erros no processamento: " + inconsistencias.size());
					for(String erro : inconsistencias) {
						System.out.println("- " + erro);
					}
				} catch (PedidoSemPublicacoesException e) {
					System.out.println(e.getMessage());
				}
				
				leitura.close();
				escrita.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Processamento finalizado!!!");
		}
	}
}
