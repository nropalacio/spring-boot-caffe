package com.nebulastorm.springboot.app.controllers;

import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nebulastorm.springboot.app.models.entity.Placa;

public interface ICrudController {

	@GetMapping("/form")
	public String crear(Model model);
	
	@GetMapping("/listar")
	public String listar(Model model);
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash);
}
