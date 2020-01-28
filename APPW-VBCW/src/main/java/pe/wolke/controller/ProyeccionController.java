package pe.wolke.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.wolke.model.entity.Proyeccion;
import pe.wolke.model.service.IPeliculaService;
import pe.wolke.model.service.IProyeccionService;
import pe.wolke.model.service.ISalaService;

@Controller
public class ProyeccionController {
	
	@Autowired
	@Qualifier("salaServiceImpl")
	private ISalaService salaService;
	
	@Autowired
	@Qualifier("peliculaServiceImpl")
	private IPeliculaService peliculaService;
	
	@Autowired
	@Qualifier("proyeccionServiceImpl")
	private IProyeccionService proyeccionService;
	
	/* Listar */
	@RequestMapping(value = "/gestion_proyecciones", method = RequestMethod.GET)
	public String proyecciones_GET(Model model, @RequestParam(value="id" ,required = false) Integer id_proyeccion) {
		
		model.addAttribute("Salas", salaService.findAll());
		model.addAttribute("Peliculas", peliculaService.findAll());
		model.addAttribute("Proyecciones", proyeccionService.findAll());
		Proyeccion proyeccion = new Proyeccion();
		
		// Editar
		if (id_proyeccion != null && id_proyeccion > 0) {
			proyeccion = proyeccionService.findById(id_proyeccion);
		}
		
		model.addAttribute("proyeccion", proyeccion);		
		return "gestion_proyecciones";
	}
	

	/* Registrar o Editar */
	@RequestMapping(value = "/gestion_proyecciones", method = RequestMethod.POST)
	public String registrar_proyeccion_POST(@Valid Proyeccion proyeccion, BindingResult result, 
											@RequestParam(value="id" ,required = false) Integer id_proyeccion, 
											RedirectAttributes flash, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("Salas", salaService.findAll());
			model.addAttribute("Peliculas", peliculaService.findAll());
			model.addAttribute("Proyecciones", proyeccionService.findAll());
			return "gestion_proyecciones";
		}							
		
		if (id_proyeccion != null && id_proyeccion > 0) {
			proyeccionService.update(proyeccion);
			flash.addFlashAttribute("success", "Proyeccion Editada con exito");
		} else {
			proyeccionService.insert(proyeccion);		
			flash.addFlashAttribute("success", "Proyeccion Registrada con exito");	
		}		
		
		return "redirect:/gestion_proyecciones";
	}
	
	/* Eliminar */
	@RequestMapping(value = "/eliminar_proyeccion/{id}")
	public String eliminar_proyecciones(@PathVariable(value="id") Integer id_proyeccion, RedirectAttributes flash) {
		
		if (id_proyeccion != null && id_proyeccion > 0 
				&& proyeccionService.findById(id_proyeccion).getItemsReservaButaca().size() == 0) 
		{
			proyeccionService.delete(id_proyeccion);
			flash.addFlashAttribute("success", "Proyeccion Eliminada con exito");
		}
		else 
		{
			flash.addFlashAttribute("error", "El id no exite o esta proyeccion está siendo usada");
		}
		
		return "redirect:/gestion_proyecciones";
	}
	
	

}
