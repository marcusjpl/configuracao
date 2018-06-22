package org.ecad.configuracao.controller;

import java.util.List;

import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;

	@RequestMapping(value = "/salvarSistema", method = RequestMethod.POST)
	public ResponseEntity<Sistema> save(@RequestBody String msg) {
		try {
			sistemaService.salvar(msg);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/buscarSistema", method = RequestMethod.GET)
	public ResponseEntity<Sistema> buscar() {
		try {
			List<Sistema> resultado = sistemaService.buscar();
			System.out.println(resultado);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
