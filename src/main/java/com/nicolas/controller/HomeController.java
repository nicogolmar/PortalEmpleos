package com.nicolas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicolas.Service.ICategoriasService;
import com.nicolas.Service.IUsuariosService;
import com.nicolas.Service.IVacantesService;
import com.nicolas.model.Perfil;
import com.nicolas.model.Usuario;
import com.nicolas.model.Vacante;


@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;

	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	
	@GetMapping("/")
	//La creacion de variable Model es para pasar a la visa datos
	public String mostrarHome(Model model) {
	/*	
		model.addAttribute("mensaje","BIENVENIDOS AL PORTAL DE EMPLEOS");
		model.addAttribute("fecha", new Date());
		return "home";
	*/	
	
		
		return "home";
	}
	
	
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
	
	
	@GetMapping("/singup")
	public String registrarse(Usuario usuario) {
		
		return "usuarios/formRegistro";
		
		
	}
	
	@PostMapping("/singup")
	public String guardarRegistro(Usuario usuario,BindingResult result, RedirectAttributes attributes) {
			
		if(result.hasErrors()) {
			
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				}

			return "usuarios/formRegistro";
		}
		
		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor
		
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		List<Perfil> perfiles = new ArrayList<>();
		perfiles.add(perfil);
		usuario.setPerfiles(perfiles);
		
		
		attributes.addFlashAttribute("msg","Registro Guardado");
		serviceUsuarios.guardar(usuario);
		
		
		return "redirect:/usuarios/index";
		
		
	}
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search")  Vacante vacante , Model model) {
		//buscador por una parte de la descripcion ( dinamico)
				ExampleMatcher matcher=ExampleMatcher.
						matching().
						withMatcher("nombre", ExampleMatcher.GenericPropertyMatchers.contains());
		System.out.println("buscando por " + vacante);
		Example<Vacante> example =Example.of(vacante,matcher);
		List<Vacante>lista=serviceVacantes.BuscarByExample(example);
		model.addAttribute("vacantes",lista);
		
		
		
		return "home";
	}
	
	
	//en caso de que un string este vacio le da valor null
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	
	@ModelAttribute
	public void setGenerico(Model model) {
		Vacante vacanteSearch=new Vacante();
		vacanteSearch.reset();
		model.addAttribute("vacantes",serviceVacantes.buscarDestacadas());
		model.addAttribute("categorias",serviceCategorias.buscarTodas());
		model.addAttribute("search",vacanteSearch);
	}
	
	
	
}
