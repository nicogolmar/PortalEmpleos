package com.nicolas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriasController {


	@GetMapping("/index")
	public String mostrarIndex(Model model) { 
	return "categorias/listCategorias";
	}
	@GetMapping("/create")
	public String crear() {
	return "categorias/formCategoria";
	}
	@PostMapping("/save")
	public String guardar() {
	return "categorias/listCategorias";
	}
	
}
