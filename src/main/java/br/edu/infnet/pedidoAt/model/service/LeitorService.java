package br.edu.infnet.pedidoAt.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.pedidoAt.model.domain.Leitor;
import br.edu.infnet.pedidoAt.model.domain.Usuario;
import br.edu.infnet.pedidoAt.model.repository.LeitorRepository;

@Service
public class LeitorService {
	
	@Autowired
	private LeitorRepository leitorRepository;

	public Collection<Leitor> obterLista(Usuario usuario){		
		return (Collection<Leitor>) leitorRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Collection<Leitor> obterLista(){		
		return (Collection<Leitor>) leitorRepository.findAll();
	}
	
	public Leitor incluir(Leitor leitor){
		return leitorRepository.save(leitor);
	}
	
	public void excluir(Integer id) {
		leitorRepository.deleteById(id);
	}
	
	public Leitor obterPorId(Integer id) {
		return leitorRepository.findById(id).orElse(null);
	}

	public Integer obterQtde(){
		return (int) leitorRepository.count();
	}
}
