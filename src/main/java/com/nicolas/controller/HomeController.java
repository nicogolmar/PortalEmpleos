package com.nicolas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nicolas.model.Vacante;


@Controller
public class HomeController {
	
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		
		List <Vacante> lista = getVacantes();
		
		
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
		
		String nombre = "Auxiliar de Farmacia";
		Date fechaPublicacion = new Date();
		double salario=9000;
		boolean vigente=true;
		
		model.addAttribute("nombre",nombre);
		model.addAttribute("fecha",fechaPublicacion);
		model.addAttribute("salario",salario);
		model.addAttribute("vigente",vigente);
		
		return "home";
	}
	
	
	private List<Vacante> getVacantes(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		List<Vacante> lista = new LinkedList<Vacante>();
		
		try {
			
			Vacante vacante1=new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Se solicita Ingeniero Civil para la construccion de Puentes");
			vacante1.setFecha(sdf.parse("04-04-2023"));
			vacante1.setSalario(4500d);
			
			Vacante vacante2=new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero Mecanico");
			vacante2.setDescripcion("Se solicita Ingeniero Mecanico para la construccion de Motores");
			vacante2.setFecha(sdf.parse("04-04-2023"));
			vacante2.setSalario(1500d);
			
			Vacante vacante3=new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero de Software");
			vacante3.setDescripcion("Se solicita Ingeniero de Software para la creacion de un nuevo sistema");
			vacante3.setFecha(sdf.parse("04-04-2023"));
			vacante3.setSalario(6500d);
			
			Vacante vacante4=new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero Nautico");
			vacante4.setDescripcion("Se solicita Ingeniero Nautico para la reparacion de motores de Navios");
			vacante4.setFecha(sdf.parse("04-04-2023"));
			vacante4.setSalario(2500d);
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		}
		catch(ParseException e) {
			System.out.print(e);
			
		}
		return lista;
	}

}
