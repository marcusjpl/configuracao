package org.ecad.configuracao.repository;

import org.ecad.configuracao.model.Propriedade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends CrudRepository<Propriedade, Integer> {
	
}
