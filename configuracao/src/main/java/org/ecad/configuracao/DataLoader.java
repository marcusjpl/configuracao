package org.ecad.configuracao;

import org.ecad.configuracao.model.Ambiente;
import org.ecad.configuracao.model.Propriedade;
import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.repository.AmbienteRepository;
import org.ecad.configuracao.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private AmbienteRepository ambienteRepository;
    private SistemaRepository sistemaRepository;

    @Autowired
    public DataLoader(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
    	Ambiente homolog = ambienteRepository.save(new Ambiente("HOMOLOG", "Homologacao"));
        Ambiente desenv = ambienteRepository.save(new Ambiente("DESENV", "Desenvolvimento"));
        Ambiente prod = ambienteRepository.save(new Ambiente("PROD", "Producao"));
        
//        Propriedade propriedade = new Propriedade();
//        
//        sistemaRepository.save(new Sistema(homolog,"SGA", "Sistema de gestao de arrecadacao"));
//        sistemaRepository.save(new Sistema(desenv,"SGI", "Sistema de gestao de inadimplencia"));
//        sistemaRepository.save(new Sistema(prod,"CAPTACAO", "Sistema de captacao"));
    }

	
}
