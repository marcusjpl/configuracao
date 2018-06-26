package org.ecad.configuracao.service;

import java.util.List;

import org.ecad.configuracao.model.Propriedade;
import org.ecad.configuracao.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropriedadeService {

	@Autowired
	private PropriedadeRepository propriedadeRepository;

	public void salvar(String msg) {
		Propriedade p = new Propriedade();
		p.setDescricao("Teste");
		propriedadeRepository.save(p);
	}

	public List<Propriedade> buscar() {
		return (List<Propriedade>) propriedadeRepository.findAll();
	}

	public void salvar(Propriedade p) {
		propriedadeRepository.save(p);
	}


}
