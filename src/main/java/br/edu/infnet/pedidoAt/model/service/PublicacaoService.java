package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Publicacao;
import br.edu.infnet.pedidoAt.model.repository.PublicacaoRepository;

@Service
public class PublicacaoService {

	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	public void incluir(Publicacao publicacao) {
		publicacaoRepository.save(publicacao);
	}

	public void excluir(Integer id) {
		publicacaoRepository.deleteById(id);
	}

	public Publicacao obterPorId(Integer id) {
		return publicacaoRepository.findById(id).orElse(null);
	}

	public Collection<Publicacao> obterLista() {
		return (Collection<Publicacao>) publicacaoRepository.findAll(); 
	}	
}