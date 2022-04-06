package br.edu.infnet.pedidoAt.model.repository;

import org.springframework.stereotype.Repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.pedidoAt.model.domain.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{

	@Query("from Livro l where l.usuario.id = :idUsuario")
	Collection<Livro> findAll(Integer idUsuario, Sort by);
	
	Collection<Livro> findAll(Sort by);
}
