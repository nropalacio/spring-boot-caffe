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
import com.nebulastorm.springboot.app.models.entity.Variedad;
import com.nebulastorm.springboot.app.services.IVariedadService;

@Controller
@RequestMapping("/admistracion/variedad")
@SessionAttributes("variedad")
public class VariedadController {
	
	@Autowired
	private IVariedadService variedadService;
	
	@GetMapping("/form")
	public String crear(Model model) {
		Variedad variedad = new Variedad();
		model.addAttribute("variedad", variedad);
		model.addAttribute("titulo", "Nueva Variedad");
		return "admistracion/variedad/form";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Variedad> variedades = variedadService.findAll(); 
		model.addAttribute("titulo", "Lista de variedades");
		model.addAttribute("variedades", variedades);
		return "admistracion/variedad/listar";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Variedad variedad, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Nueva Variedad");
			return "admistracion/variedad/form";
		}
		
		variedadService.save(variedad);
		status.setComplete();
		flash.addFlashAttribute("success", "Variedad creada con exito");;
		return "redirect:/admistracion/variedad/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if(id > 0) {
			variedadService.delete(id);
			flash.addFlashAttribute("success", "Variedad eliminada con exito");
		}
		
		return "redirect:/admistracion/variedad/listar";
	}
	
	

}
