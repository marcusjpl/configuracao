package org.ecad.configuracao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@GetMapping("/configuracao/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/configuracao")
	public String home(Map<String, Object> model) {
		return "home";
	}
	
	@GetMapping("/configuracao/")
	public String inicio(Map<String, Object> model) {
		return "home";
	}
	
	@GetMapping("/view/sistema.html")
	public String sistema(Map<String, Object> model) {
		return "view/sistema.html";
	}
	
	@GetMapping("/view/ambiente.html")
	public String ambiente(Map<String, Object> model) {
		return "view/ambiente.html";
	}
	
	@GetMapping("/view/propriedade.html")
	public String propriedade(Map<String, Object> model) {
		return "view/propriedade.html";
	}
	
	@GetMapping("/view/inicial.html")
	public String inicial(Map<String, Object> model) {
		return "view/inicial.html";
	}
	
	@GetMapping("/menu.html")
	public String menuVertical(Map<String, Object> model) {
		return "includes/menu.html";
	}
	
	@GetMapping("/header.html")
	public String menuHorizontal(Map<String, Object> model) {
		return "includes/header.html";
	}

	@GetMapping	("/swagger")
	public String home() {
		return "redirect:/swagger-ui.html";
	}

}