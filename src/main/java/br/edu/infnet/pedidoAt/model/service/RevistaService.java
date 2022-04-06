package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Revista;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.repository.RevistaRepository;

@Service
public class RevistaService {
	
	@Autowired
	private RevistaRepository revistaRepository;

	public Collection<Revista> obterLista(Usuario usuario) {
		return (Collection<Revista>) revistaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "titulo")); 
	}	
	public Collection<Revista> obterLista() {
		return (Collection<Revista>) revistaRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo")); 
	}
}
