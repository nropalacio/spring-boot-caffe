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

import com.nebulastorm.springboot.app.models.entity.Calidad;
import com.nebulastorm.springboot.app.services.ICalidadService;


@Controller
@RequestMapping("/admistracion/calidad")
@SessionAttributes("calidad")
public class CalidadController {

	@Autowired
	private ICalidadService calidadService;
	
	@GetMapping("/form")
	public String crear(Model model) {
		Calidad calidad = new Calidad();
		model.addAttribute("calidad", calidad);
		model.addAttribute("titulo", "Formulario Calidad");
		return "admistracion/calidad/form";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Calidad> calidades = calidadService.findAll(); 
		model.addAttribute("titulo", "Lista de calidades");
		model.addAttribute("calidades", calidades);
		return "admistracion/calidad/listar";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Calidad calidad, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Calidad");
			return "admistracion/calidad/form";
		}
		
		calidadService.save(calidad);
		status.setComplete();
		flash.addFlashAttribute("success", "Calidad creada con exito");;
		return "redirect:/admistracion/calidad/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if(id > 0) {
			calidadService.delete(id);
			flash.addFlashAttribute("success", "Calidad eliminada con exito");
		}
		
		return "redirect:/admistracion/calidad/listar";
	}
	
}
