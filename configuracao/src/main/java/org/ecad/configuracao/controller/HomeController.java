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
	public String welcome(Map<String, Object> model) {
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
	
	@GetMapping("/menu_vertical.html")
	public String menuVertical(Map<String, Object> model) {
		return "includes/menu_vertical.html";
	}
	
	@GetMapping("/menu_horizontal.html")
	public String menuHorizontal(Map<String, Object> model) {
		return "includes/menu_horizontal.html";
	}

	@GetMapping	("/swagger")
	public String home() {
		return "redirect:/swagger-ui.html";
	}

}