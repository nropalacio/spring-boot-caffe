package com.nebulastorm.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("title", "Excomer APP");
		model.addAttribute("bienvenido", "Bienvenido al sistema de Etradas de Cafe");
		return "index";
	}
}
