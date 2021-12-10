package br.edu.infnet.pedidoAt.model.domain;

import br.edu.infnet.pedidoAt.exceptions.CpfInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.EmailInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.NomeInvalidoException;

public class Leitor {
	
	private String nome;
	private String email;
	private String cpf;

	public Leitor(String nome, String email, String cpf) throws NomeInvalidoException, EmailInvalidoException, CpfInvalidoException {
		
		if(nome == null) {
			throw new NomeInvalidoException("O nome do leitor está nulo!!!");
		}
		
		if(email == null) {
			throw new EmailInvalidoException("O e-mail do leitor " + nome + " está nulo!!!");
		}

		if(cpf == null) {
			throw new CpfInvalidoException("O CPF do leitor " + nome + " está nulo!!!");
		}

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		sb.append(cpf);
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}	

}
