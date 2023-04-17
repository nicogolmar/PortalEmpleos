package com.nicolas.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nicolas.Service.IVacantesService;
import com.nicolas.model.Vacante;


@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		
		List <Vacante> lista = serviceVacantes.buscarTodas();
		
		
		model.addAttribute("vacantes",lista);
		
		
		
		return "tabla";
		
		
		
	}
	
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		
		Vacante vacante = new Vacante();
		
		vacante.setNombre("Ingeniero en Sistemas");
		vacante.setDescripcion("Se solicita ingeniero para el desarollo de software de alta complejidad");
		vacante.setFecha(new Date());
		vacante.setSalario(3000d);
		
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}
	
	
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List <String> lista = new LinkedList<String>();
		
		lista.add("Ingeniero en Sistemas");
		lista.add("Vendedor de Pintura");
		lista.add("Arquitecto");
		lista.add("Administrativo");
		
		
		model.addAttribute("empleos",lista);
		
		return "listado";
		
		
	}
	
	
	
	
	
	@GetMapping("/")
	//La creacion de variable Model es para pasar a la visa datos
	public String mostrarHome(Model model) {
	/*	
		model.addAttribute("mensaje","BIENVENIDOS AL PORTAL DE EMPLEOS");
		model.addAttribute("fecha", new Date());
		return "home";
	*/	
		List <Vacante> lista = serviceVacantes.buscarTodas();
		
		
		model.addAttribute("vacantes",lista);
		
	
		
		return "home";
	}
	
	
	
}
