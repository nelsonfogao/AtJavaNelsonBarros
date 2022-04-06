package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.repository.MangaRepository;

@Service
public class MangaService {
	
	@Autowired
	private MangaRepository mangaRepository;

	public Collection<Manga> obterLista(Usuario usuario) {
		return (Collection<Manga>) mangaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "titulo")); 
	}	
	public Collection<Manga> obterLista() {
		return (Collection<Manga>) mangaRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo")); 
	}	
}