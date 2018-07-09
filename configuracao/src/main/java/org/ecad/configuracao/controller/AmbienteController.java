package org.ecad.configuracao.controller;

import java.util.List;

import org.ecad.configuracao.model.Ambiente;
import org.ecad.configuracao.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AmbienteController {

	@Autowired
	private AmbienteRepository ambienteRepository;
	
	
	@GetMapping("ambiente/{id}")
	public ResponseEntity<Ambiente> getById(@PathVariable("id") Long id) {
		Ambiente ambiente = ambienteRepository.findById(id).get();
		if (ambiente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ambiente>(ambiente, HttpStatus.OK);
	}
	
	@PutMapping("ambiente")
	public ResponseEntity<Ambiente> atualizar(@RequestBody Ambiente ambiente) {
		ambienteRepository.save(ambiente);
		return new ResponseEntity<Ambiente>(ambiente, HttpStatus.OK);
	}

	@PostMapping("ambiente")
	public ResponseEntity<Ambiente> salvar(@RequestBody Ambiente ambiente) {
		Ambiente retorno = null;
		try {
			retorno = ambienteRepository.save(ambiente);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Ambiente>(retorno, HttpStatus.OK);
	}

	@DeleteMapping("ambiente/{id}")
	public ResponseEntity<Ambiente> remover(@PathVariable("id") Long id) {
		Ambiente ambiente = ambienteRepository.findById(id).get();
		if (ambiente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ambienteRepository.deleteById(id);
		return new ResponseEntity<Ambiente>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("ambientes")
	public ResponseEntity<List<Ambiente>> getAll() {
		List<Ambiente> result = (List<Ambiente>) ambienteRepository.findAll();
		return new ResponseEntity<List<Ambiente>>(result, HttpStatus.OK);
	}
	
	@GetMapping("ambiente/sistema/{id}")
	public ResponseEntity<List<Ambiente>> getBySistemaId(@PathVariable("id") Long id) {
		List<Ambiente> result = (List<Ambiente>) ambienteRepository.findBySistemaId(id);
		return new ResponseEntity<List<Ambiente>>(result, HttpStatus.OK);
	}

}
