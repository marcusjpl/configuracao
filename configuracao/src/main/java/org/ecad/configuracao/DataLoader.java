package org.ecad.configuracao;

import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private SistemaRepository sistemaRepository;

	@Autowired
	public DataLoader(SistemaRepository sistemaRepository) {
		this.sistemaRepository = sistemaRepository;
	}

	@Override
	public void run(ApplicationArguments args) {
		sistemaRepository.save(new Sistema("SGA", "sga"));
		sistemaRepository.save(new Sistema("SGI", "sgi"));
		sistemaRepository.save(new Sistema("Captacao", "captacao"));
	}

}
