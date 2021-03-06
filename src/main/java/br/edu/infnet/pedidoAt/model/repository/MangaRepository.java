package br.edu.infnet.pedidoAt.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pedidoAt.model.domain.Manga;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Integer>{

	@Query("from Manga m where m.usuario.id = :idUsuario")
	Collection<Manga> findAll(Integer idUsuario, Sort by);
	
	Collection<Manga> findAll(Sort by);
}
