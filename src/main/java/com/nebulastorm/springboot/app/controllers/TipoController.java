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

import com.nebulastorm.springboot.app.models.entity.Tipo;
import com.nebulastorm.springboot.app.services.ITipoService;

@Controller
@RequestMapping("/admistracion/tipo")
@SessionAttributes("tipo")
public class TipoController {
	
	@Autowired
	private ITipoService tipoService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Tipo> tipos = tipoService.findAll();
		model.addAttribute("titulo", "Lista de tipos de cafe");
		model.addAttribute("tipos", tipos);
		return "admistracion/tipo/listar";
	}
	
	@GetMapping("/form")
	public String crear(Model model) {
		Tipo tipo = new Tipo();
		model.addAttribute("titulo", "Nuevo Tipo de Cafe");
		model.addAttribute("tipo", tipo);
		return "admistracion/tipo/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Tipo tipo, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo Tipo de Cafe");
			return "admistracion/tipo/form";
		}
		
		tipoService.save(tipo);
		status.setComplete();
		flash.addFlashAttribute("success", "Tipo creado con exito");
		return "redirect:/admistracion/tipo/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			tipoService.delete(id);
			flash.addFlashAttribute("success", "Tipo de cafe eliminado con exito");
		}
		return "redirect:/admistracion/tipo/listar";
	}
	
	
	
	
	
	
	
	
	

}
