package org.ecad.configuracao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/configuracao")
	public String welcome(Map<String, Object> model) {
		return "index";
	}
	
	@RequestMapping("/view/sistema.html")
	public String sistema(Map<String, Object> model) {
		return "view/sistema.html";
	}
	
	@RequestMapping("/view/ambiente.html")
	public String ambiente(Map<String, Object> model) {
		return "view/ambiente.html";
	}
	
	@RequestMapping("/view/propriedade.html")
	public String propriedade(Map<String, Object> model) {
		return "view/propriedade.html";
	}
	
	@RequestMapping("/view/inicial.html")
	public String inicial(Map<String, Object> model) {
		return "view/inicial.html";
	}
	
	@RequestMapping("/menu_vertical.html")
	public String menuVertical(Map<String, Object> model) {
		return "includes/menu_vertical.html";
	}
	
	@RequestMapping("/menu_horizontal.html")
	public String menuHorizontal(Map<String, Object> model) {
		return "includes/menu_horizontal.html";
	}
	
	@RequestMapping("configuracao/forms.html")
	public String forms(Map<String, Object> model) {
		return "configuracao/forms";
	}
	
	@RequestMapping("configuracao/tables.html")
	public String tables(Map<String, Object> model) {
		return "configuracao/tables";
	}
	
	@RequestMapping("configuracao/grid.html")
	public String grid(Map<String, Object> model) {
		return "configuracao/grid";
	}
	
	@RequestMapping("configuracao/login.html")
	public String login(Map<String, Object> model) {
		return "configuracao/login";
	}
	
	@RequestMapping("configuracao/buttons.html")
	public String buttons(Map<String, Object> model) {
		return "configuracao/buttons";
	}
	
	@RequestMapping("configuracao/notifications.html")
	public String notifications(Map<String, Object> model) {
		return "configuracao/notifications";
	}
	
	@RequestMapping("configuracao/panels-wells.html")
	public String panels(Map<String, Object> model) {
		return "configuracao/panels-wells";
	}
	
	@RequestMapping("configuracao/icons.html")
	public String icons(Map<String, Object> model) {
		return "configuracao/icons";
	}
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "configuracao/";
	}

	@RequestMapping("/swagger")
	public String home() {
		return "redirect:/swagger-ui.html";
	}

}