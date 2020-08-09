package com.nebulastorm.springboot.app.controllers;

import java.util.ArrayList;
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

import com.nebulastorm.springboot.app.models.dao.IPlacaDao;
import com.nebulastorm.springboot.app.models.entity.Motorista;
import com.nebulastorm.springboot.app.models.entity.Placa;
import com.nebulastorm.springboot.app.services.IMotoristaService;
import com.nebulastorm.springboot.app.services.IPlacaService;


@Controller
@RequestMapping("/transporte/motorista")
@SessionAttributes("motorista")
public class MotoristaController {

	@Autowired
	private IMotoristaService motoristaService;
	
	@Autowired
	private IPlacaService placaService;
	
	@GetMapping("/form")
	public String crear(Model model) {
		Motorista motorista = new Motorista();
		List<Placa> placas = placaService.findAll();
		model.addAttribute("motorista", motorista);
		model.addAttribute("placas", placas);
		model.addAttribute("titulo", "Formulario Motorista");
		return "transporte/motorista/form";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Motorista> motoristas = motoristaService.findAll(); 
		model.addAttribute("titulo", "Listado de motoristas");
		model.addAttribute("motoristas", motoristas);
		return "transporte/motorista/listar";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Motorista motorista, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if (result.hasErrors()) {
			List<Placa> placas = placaService.findAll();
			model.addAttribute("placas", placas);
			model.addAttribute("titulo", "Formulario Motorista");
			return "transporte/motorista/form";
		}
		
		motoristaService.save(motorista);
		status.setComplete();
		flash.addFlashAttribute("success", "Motorista creado con exito");;
		return "redirect:/transporte/motorista/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if(id > 0) {
			motoristaService.delete(id);
			flash.addFlashAttribute("success", "Motorista eliminado con exito");
		}
		
		return "redirect:/transporte/motorista/listar";
	}
	
}
