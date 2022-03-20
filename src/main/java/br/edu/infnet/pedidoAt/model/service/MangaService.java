package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Manga;
import br.edu.infnet.pedidoAt.model.repository.MangaRepository;

@Service
public class MangaService {
	
	@Autowired
	private MangaRepository mangaRepository;

	public Collection<Manga> obterLista() {
		return (Collection<Manga>) mangaRepository.findAll(); 
	}		
}