package com.nicolas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCategoria,Model model){
		Categorias categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categorias", categoria);
		serviceCategorias.guardar(categoria);
		return "categorias/formCategoria";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria,RedirectAttributes attributes){
		
		serviceCategorias.eliminar(idCategoria);
		
		attributes.addFlashAttribute("msgDelete","Categoria Eliminada");
		
		
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categorias> lista = serviceCategorias.buscarTodas(page);
	model.addAttribute("categorias", lista);
	return "categorias/listCategorias";
	}
	
	
}
