package com.nicolas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicolas.Service.ICategoriasService;
import com.nicolas.model.Categorias;


@RequestMapping("/categorias")
@Controller
public class CategoriasController {

	@Autowired
	private ICategoriasService serviceCategorias;
	

	@GetMapping("/index")
	public String mostrarIndex(Categorias categoria , Model model) { 
		
		
		
		List <Categorias> lista = serviceCategorias.buscarTodas();
	
		model.addAttribute("categorias",lista);
		
		
	return "categorias/listCategorias";
	
	
	}
	
	
	@GetMapping("/create")
	public String crear(Categorias categoria) {
		
	return "categorias/formCategoria";
	
	}
	
	
	@PostMapping("/save")
	public String guardar(Categorias categoria,BindingResult result, Model model,RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				}

			return "categorias/formCategoria";
		}
		
		attributes.addFlashAttribute("msg","Registro Guardado");
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/index";
	}
	
}
