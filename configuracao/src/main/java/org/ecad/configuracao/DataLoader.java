package org.ecad.configuracao;

import org.ecad.configuracao.model.Ambiente;
import org.ecad.configuracao.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private AmbienteRepository ambienteRepository;

    @Autowired
    public DataLoader(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        ambienteRepository.save(new Ambiente("HOMOLOG", "Homologacao"));
        ambienteRepository.save(new Ambiente("DESENV", "Desenvolvimento"));
        ambienteRepository.save(new Ambiente("PROD", "Producao"));
    }

	
}
