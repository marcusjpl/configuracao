package org.ecad.configuracao.repository;

import org.ecad.configuracao.model.Sistema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaRepository extends CrudRepository<Sistema, Integer> {
	
}
