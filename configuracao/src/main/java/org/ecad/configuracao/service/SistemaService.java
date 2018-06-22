package org.ecad.configuracao.service;

import java.util.List;

import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;

	public void salvar(String msg) {
		Sistema s = new Sistema();
		s.setDescricao("Teste");
		s.setNome("SGA");
		sistemaRepository.save(s);
	}

	public List<Sistema> buscar() {
		return (List<Sistema>) sistemaRepository.findAll();
	}


}
