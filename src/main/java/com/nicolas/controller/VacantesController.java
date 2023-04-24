package com.nicolas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicolas.Service.IVacantesService;
import com.nicolas.model.Vacante;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;
	
	
	
	@GetMapping("/create")
	public String crear(Vacante vacante) {
		
		
		
		return "vacantes/formVacante";
		
	}
	
	/*
	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("categoria") int categoria,
			@RequestParam("estatus") String estatus,
			@RequestParam("fecha") String fecha, 
			@RequestParam("destacado") int destacado ,
			@RequestParam("salario") Double salario,
			@RequestParam("detalles") String detalles) 
	{
		
		System.out.println("Nombre de vacante : "+nombre);
		System.out.println("Descripcion de vacante : "+descripcion);
		System.out.println("Categoria de vacante : "+categoria);
		System.out.println("Estado de vacante : "+estatus);
		System.out.println("Fecha de vacante : "+fecha);
		System.out.println("Destacado de vacante : "+destacado);
		System.out.println("Salario de vacante : "+salario);
		System.out.println("Detalle de vacante : "+detalles);
		
		return "vacantes/listVacantes";
		
	}
	*/
	@PostMapping("/save")
	public String guardar(Vacante vacante,BindingResult result, Model model,RedirectAttributes attributes) 
	{
		
		if(result.hasErrors()) {
			
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				}

			return "vacantes/formVacante";
		}
		
		
		serviceVacantes.guardar(vacante);
		
		attributes.addFlashAttribute("msg","Registro Guardado");
		return "redirect:/vacantes/listaVacantes";
		
	}
	
	
	@GetMapping("/listaVacantes")
	public String mostrarVacantes(Vacante vacante, Model model) 
	{
		
		List <Vacante> lista = serviceVacantes.buscarTodas();
	
		model.addAttribute("vacantes",lista);
		
		return "vacantes/listVacantes";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante , Model model) {
		
		System.out.print("Se elimino la vacante con ID " + idVacante);
		
		model.addAttribute("idVacante", idVacante);
		
		
		return "mensaje";
		
	}
	
	
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante , Model model) {
		
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		
		System.out.println("EL ID DE LA VACANTE ES "+ vacante);
		
		model.addAttribute("vacante", vacante);
		
		return "detalle";
		
		
		
	}
	
	
	
}
