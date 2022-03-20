package br.edu.infnet.pedidoAt.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.pedidoAt.model.domain.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
