package br.edu.infnet.pedidoAt.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pedidoAt.model.domain.Publicacao;

@Repository
public interface PublicacaoRepository extends CrudRepository<Publicacao, Integer> {

	@Query("from Publicacao p where p.usuario.id = :idUsuario")	
	Collection<Publicacao> findAll(Integer idUsuario, Sort by);
	
	Collection<Publicacao> findAll(Sort by);
}
