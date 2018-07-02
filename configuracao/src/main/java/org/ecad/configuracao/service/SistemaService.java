package org.ecad.configuracao.service;

import java.util.List;

import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.repository.SistemaRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;

	public Sistema findById(Long id) {
		return sistemaRepository.findById(id).get();
	}

	public Sistema save(Sistema sistema) {
		return sistemaRepository.save(sistema);
	}

	public String deleteById(Long id) {
		try {
			sistemaRepository.deleteById(id);
			return null;
		} catch (ConstraintViolationException c) {
			return "Esse sistema já possui Ambiente Cadastrado";
		}
	}

	public List<Sistema> findAll() {
		return (List<Sistema>) sistemaRepository.findAll();
	}
	
}
