package org.ecad.configuracao.controller;

import java.util.List;

import org.ecad.configuracao.model.Propriedade;
import org.ecad.configuracao.model.Sistema;
import org.ecad.configuracao.service.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propriedade")
public class PropriedadeController {

	@Autowired
	private PropriedadeService propriedadeService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, 
			consumes = {"application/json" }, produces = { "application/json" })
	public ResponseEntity<Sistema> save(@RequestBody Propriedade p) {
		try {
			propriedadeService.salvar(p);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/propriedades", method = RequestMethod.GET)
	public @ResponseBody List<Propriedade> buscar() {
		return propriedadeService.buscar();
	}

}
