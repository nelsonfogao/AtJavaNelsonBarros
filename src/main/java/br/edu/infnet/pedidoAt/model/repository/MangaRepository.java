package br.edu.infnet.pedidoAt.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pedidoAt.model.domain.Manga;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Integer>{

}
