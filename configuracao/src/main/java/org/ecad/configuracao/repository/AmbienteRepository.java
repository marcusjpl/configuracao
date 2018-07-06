package org.ecad.configuracao.repository;

import java.util.List;

import org.ecad.configuracao.model.Ambiente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends CrudRepository<Ambiente, Long> {

	@Query("select a from Ambiente a where a.sistema.id = :id")
	List<Ambiente> findBySistemaId(@Param("id") Long id);
	
}
