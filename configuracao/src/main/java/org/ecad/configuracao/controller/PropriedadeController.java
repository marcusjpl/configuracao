package org.ecad.configuracao.controller;

import java.util.List;

import org.ecad.configuracao.model.Propriedade;
import org.ecad.configuracao.service.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropriedadeController {

	@Autowired
	private PropriedadeService exemploService;

	@RequestMapping(value = "/salvarMensagem", method = RequestMethod.PUT, consumes = {
			"application/json" }, produces = { "application/json" })
	public ResponseEntity<Propriedade> save(@RequestBody Propriedade msg) {
		try {
			///
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/salvarTeste", method = RequestMethod.POST)
	public ResponseEntity<Propriedade> save(@RequestBody String msg) {
		try {
			exemploService.salvar(msg);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<Propriedade> buscar() {
		try {
			List<Propriedade> resultado = exemploService.buscar();
			System.out.println(resultado);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
