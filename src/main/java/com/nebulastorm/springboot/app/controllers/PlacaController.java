package com.nebulastorm.springboot.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nebulastorm.springboot.app.models.entity.Placa;
import com.nebulastorm.springboot.app.services.IPlacaService;

@Controller
@RequestMapping("/transporte/placa")
@SessionAttributes("placa")
public class PlacaController {
	
	@Autowired
	private IPlacaService placaService;
	
	@GetMapping("/form")
	public String crear(Model model) {
		Placa placa = new Placa();
		model.addAttribute("placa", placa);
		model.addAttribute("titulo", "Formulario Placa");
		return "transporte/placa/form";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Placa> placas = placaService.findAll(); 
		model.addAttribute("titulo", "Listado de placas");
		model.addAttribute("placas", placas);
		return "transporte/placa/listar";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Placa placa, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Placa");
			return "transporte/placa/form";
		}
		
		placaService.save(placa);
		status.setComplete();
		flash.addFlashAttribute("success", "Placa creada con exito");;
		return "redirect:/transporte/placa/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if(id > 0) {
			placaService.delete(id);
			flash.addFlashAttribute("success", "Placa eliminada con exito");
		}
		
		return "redirect:/transporte/placa/listar";
	}

}
