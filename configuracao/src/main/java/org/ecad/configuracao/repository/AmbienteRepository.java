package org.ecad.configuracao.repository;

import org.ecad.configuracao.model.Ambiente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends CrudRepository<Ambiente, Integer> {
	
}
