package org.ecad.configuracao.repository;

import org.ecad.configuracao.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.nome = :username")
	Usuario findByUsuario(@Param("username") String username);
	
}
