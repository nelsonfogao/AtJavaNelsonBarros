package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Livro;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public Collection<Livro> obterLista(Usuario usuario) {
		return (Collection<Livro>) livroRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "titulo")); 
	}	
	public Collection<Livro> obterLista() {
		return (Collection<Livro>) livroRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo")); 
	}
}
