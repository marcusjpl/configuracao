package org.ecad.configuracao.controller;

import java.util.List;

import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.service.SistemaService;
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
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;

	@GetMapping("sistema/{id}")
	public ResponseEntity<Sistema> getById(@PathVariable("id") Long id) {
		Sistema sistema = sistemaService.findById(id);
		if (sistema == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Sistema>(sistema, HttpStatus.OK);
	}
	
	@PutMapping("sistema")
	public ResponseEntity<Sistema> atualizar(@RequestBody Sistema sistema) {
		sistemaService.save(sistema);
		return new ResponseEntity<Sistema>(sistema, HttpStatus.OK);
	}

	@PostMapping("sistema")
	public ResponseEntity<Sistema> salvar(@RequestBody Sistema sistema) {
		Sistema retorno = null;
		try {
			retorno = sistemaService.save(sistema);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Sistema>(retorno, HttpStatus.OK);
	}

	@DeleteMapping("/sistema/{id}")
	public ResponseEntity<Sistema> remover(@PathVariable("id") Long id) {
		Sistema Sistema = sistemaService.findById(id);
		if (Sistema == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		sistemaService.deleteById(id);
		return new ResponseEntity<Sistema>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("sistemas")
	public ResponseEntity<List<Sistema>> getAll() {
		List<Sistema> result = (List<Sistema>) sistemaService.findAll();
		return new ResponseEntity<List<Sistema>>(result, HttpStatus.OK);
	}

}
