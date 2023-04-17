package com.nicolas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolas.Service.IVacantesService;
import com.nicolas.model.Vacante;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;
	
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
