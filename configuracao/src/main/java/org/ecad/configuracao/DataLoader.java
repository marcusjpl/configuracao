package org.ecad.configuracao;

import org.ecad.configuracao.model.Ambiente;
import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.model.Usuario;
import org.ecad.configuracao.repository.AmbienteRepository;
import org.ecad.configuracao.repository.SistemaRepository;
import org.ecad.configuracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private SistemaRepository sistemaRepository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;

	@Override
	public void run(ApplicationArguments args) {
		
		Usuario u = new Usuario();
		u.setNome("Marcus Loureiro");
		u.setLogin("marcus");
		u.setSenha("$2a$10$RkTVD0vVnTO9PcU2VbSOButxB3bavOmic/.cuhp4.0a9uml5Vg.bm");
		usuarioRepository.save(u);
		
		Sistema sga = sistemaRepository.save(new Sistema("SGA", "sga"));
		Sistema sgi = sistemaRepository.save(new Sistema("SGI", "sgi"));
		Sistema cap= sistemaRepository.save(new Sistema("Captacao", "captacao"));
		
		Ambiente des = ambienteRepository.save(new Ambiente("Desenv", "desenvolvimento", sga));
		Ambiente hom = ambienteRepository.save(new Ambiente("Homol", "homologacao", sga));
		Ambiente pro = ambienteRepository.save(new Ambiente("Prod", "producao", sga));
		
	}

}
