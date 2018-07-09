package org.ecad.configuracao.controller;

import java.util.List;

import org.ecad.configuracao.model.Propriedade;
import org.ecad.configuracao.repository.PropriedadeRepository;
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
public class PropriedadeController {

	@Autowired
	private PropriedadeRepository propriedadeRepository;
	
	@GetMapping("propriedade/{id}")
	public ResponseEntity<Propriedade> getById(@PathVariable("id") Long id) {
		Propriedade propriedade = propriedadeRepository.findById(id).get();
		if (propriedade == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Propriedade>(propriedade, HttpStatus.OK);
	}
	
	@PutMapping("propriedade")
	public ResponseEntity<Propriedade> atualizar(@RequestBody Propriedade propriedade) {
		propriedadeRepository.save(propriedade);
		return new ResponseEntity<Propriedade>(propriedade, HttpStatus.OK);
	}

	@PostMapping("propriedade")
	public ResponseEntity<Propriedade> salvar(@RequestBody Propriedade propriedade) {
		Propriedade retorno = null;
		try {
			retorno = propriedadeRepository.save(propriedade);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Propriedade>(retorno, HttpStatus.OK);
	}

	@DeleteMapping("/propriedade/{id}")
	public ResponseEntity<Propriedade> remover(@PathVariable("id") Long id) {
		Propriedade Propriedade = propriedadeRepository.findById(id).get();
		if (Propriedade == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		propriedadeRepository.deleteById(id);
		return new ResponseEntity<Propriedade>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("propriedade")
	public ResponseEntity<List<Propriedade>> getAll() {
		List<Propriedade> result = (List<Propriedade>) propriedadeRepository.findAll();
		return new ResponseEntity<List<Propriedade>>(result, HttpStatus.OK);
	}
	
	@GetMapping("propriedade/ambiente/{id}")
	public ResponseEntity<List<Propriedade>> getByAmbienteId(@PathVariable("id") Long id) {
		List<Propriedade> result = (List<Propriedade>) propriedadeRepository.findByAmbienteId(id);
		return new ResponseEntity<List<Propriedade>>(result, HttpStatus.OK);
	}

}
