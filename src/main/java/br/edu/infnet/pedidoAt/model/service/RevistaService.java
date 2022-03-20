package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Revista;
import br.edu.infnet.pedidoAt.model.repository.RevistaRepository;

@Service
public class RevistaService {
	
	@Autowired
	private RevistaRepository revistaRepository;

	public Collection<Revista> obterLista() {
		return (Collection<Revista>) revistaRepository.findAll(); 
	}		
}
