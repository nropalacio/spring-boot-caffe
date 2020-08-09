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

import com.nebulastorm.springboot.app.models.entity.Calidad;
import com.nebulastorm.springboot.app.models.entity.Cliente;
import com.nebulastorm.springboot.app.services.IClienteService;

@Controller
@RequestMapping("/cliente")
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente> clientes = clienteService.findAll();
		model.addAttribute("titulo", "Clientes de la empresa");
		model.addAttribute("clientes", clientes);
		return "cliente/listar";
	}
	
	@GetMapping("/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Nuevo Cliente");
		return "cliente/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Aqui fallo, nuevo cliente");
			return "cliente/form";
		}
		
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", "Cliente creado con exito");
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if(id > 0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con exito");
		}
		return "redirect:/cliente/listar";
	}
	
}
