package br.edu.infnet.pedidoAt.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pedidoAt.model.domain.Leitor;

@Repository
public interface LeitorRepository extends CrudRepository<Leitor, Integer> {

	@Query("from Leitor l where l.usuario.id = :idUsuario")
	public List<Leitor> obterLista(Integer idUsuario, Sort sort);
}
