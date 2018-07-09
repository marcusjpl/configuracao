package org.ecad.configuracao.repository;

import java.util.List;

import org.ecad.configuracao.model.Propriedade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends CrudRepository<Propriedade, Long> {

	@Query("select p from Propriedade p where p.ambiente.id = :id")
	List<Propriedade> findByAmbienteId(@Param("id") Long id);
	
}
