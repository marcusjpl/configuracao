package org.ecad.configuracao.service;

import java.util.List;

import org.ecad.configuracao.model.Propriedade;
import org.ecad.configuracao.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropriedadeService {

	@Autowired
	private PropriedadeRepository exemploRepository;

	public void salvar(String msg) {
		Propriedade p = new Propriedade();
		p.setDescricao("Teste");
		exemploRepository.save(p);
	}

	public List<Propriedade> buscar() {
		return (List<Propriedade>) exemploRepository.findAll();
	}


}
