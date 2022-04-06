package br.edu.infnet.pedidoAt.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.edu.infnet.pedidoAt.exceptions.CpfInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.EmailInvalidoException;
import br.edu.infnet.pedidoAt.exceptions.NomeInvalidoException;


@Entity
@Table(name = "TLeitor", 
	uniqueConstraints = { 
			@UniqueConstraint(columnNames = { "nome", "email" }) 
		}
)
public class Leitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

	
	public Leitor() {

	}
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	


}
