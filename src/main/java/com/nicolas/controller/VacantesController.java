package com.nicolas.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nicolas.Service.ICategoriasService;
import com.nicolas.Service.IVacantesService;
import com.nicolas.model.Vacante;
import com.nicolas.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	//inyectamos la info de la propiedad en la variable ruta desde application.properties
	@Value("${empleos.ruta.imagenes}")
	private String ruta;
	@Autowired
	private IVacantesService serviceVacantes;
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	
	
	@GetMapping("/create")
	public String crear(Vacante vacante,Model model) {
		
		
		model.addAttribute("categorias",serviceCategorias.buscarTodas());
		
		
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
	public String guardar( Vacante vacante,BindingResult result, Model model,RedirectAttributes attributes ,
			@RequestParam("archivoImagen") MultipartFile multiPart) 
	{
		
		
		
		
		if(result.hasErrors()) {
			
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				}

			
			return "vacantes/formVacante";
		}
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null)
				{
				// La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImagenVacante(nombreImagen);
				}
			}

		
		serviceVacantes.guardar(vacante);
		
		attributes.addFlashAttribute("msg","Registro Guardado");
		System.out.println(vacante);
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
