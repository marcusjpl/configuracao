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
		model.put("message", this.message);
		return "index";
	}
	
	@RequestMapping("configuracao/welcome")
	public String inicio(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/welcome.html";
	}
	
	@RequestMapping("configuracao/forms.html")
	public String forms(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/forms";
	}
	
	@RequestMapping("configuracao/tables.html")
	public String tables(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/tables";
	}
	
	@RequestMapping("configuracao/grid.html")
	public String grid(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/grid";
	}
	
	@RequestMapping("configuracao/login.html")
	public String login(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/login";
	}
	
	@RequestMapping("configuracao/buttons.html")
	public String buttons(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/buttons";
	}
	
	@RequestMapping("configuracao/notifications.html")
	public String notifications(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/notifications";
	}
	
	@RequestMapping("configuracao/panels-wells.html")
	public String panels(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/panels-wells";
	}
	
	@RequestMapping("configuracao/icons.html")
	public String icons(Map<String, Object> model) {
		model.put("message", this.message);
		return "configuracao/icons";
	}
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping("/swagger")
	public String home() {
		return "redirect:/swagger-ui.html";
	}

}