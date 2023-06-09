package com.nicolas.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicolas.Service.IUsuariosService;
import com.nicolas.model.Usuario;

@RequestMapping("/usuarios")
@Controller
public class UsuariosController {

	@Autowired
	private IUsuariosService serviceUsuarios;
	
	
	@GetMapping("/index")
	public String mostrarUsuarios(Model model) {
		
		
		List <Usuario> lista = serviceUsuarios.buscarTodos();
		
		
		model.addAttribute("usuarios",lista);
		
		
		return "usuarios/listUsuarios";
		
		
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario,RedirectAttributes attributes){
		
		serviceUsuarios.eliminar(idUsuario);
		
		attributes.addFlashAttribute("msgDelete","Usuario Eliminado");
		
		
		return "redirect:/usuarios/index";
	}
	
	
	
	
}
