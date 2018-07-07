package org.ecad.configuracao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@GetMapping("/configuracao")
	public String welcome(Map<String, Object> model) {
		return "index";
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
	
	@GetMapping("configuracao/forms.html")
	public String forms(Map<String, Object> model) {
		return "configuracao/forms";
	}
	
	@GetMapping("configuracao/tables.html")
	public String tables(Map<String, Object> model) {
		return "configuracao/tables";
	}
	
	@GetMapping("configuracao/grid.html")
	public String grid(Map<String, Object> model) {
		return "configuracao/grid";
	}
	
	@GetMapping("configuracao/login.html")
	public String login(Map<String, Object> model) {
		return "configuracao/login";
	}
	
	@GetMapping("configuracao/buttons.html")
	public String buttons(Map<String, Object> model) {
		return "configuracao/buttons";
	}
	
	@GetMapping("configuracao/notifications.html")
	public String notifications(Map<String, Object> model) {
		return "configuracao/notifications";
	}
	
	@GetMapping("configuracao/panels-wells.html")
	public String panels(Map<String, Object> model) {
		return "configuracao/panels-wells";
	}
	
	@GetMapping("configuracao/icons.html")
	public String icons(Map<String, Object> model) {
		return "configuracao/icons";
	}
	
	@GetMapping("/")
	public String index(Map<String, Object> model) {
		return "configuracao/";
	}

	@GetMapping	("/swagger")
	public String home() {
		return "redirect:/swagger-ui.html";
	}

}