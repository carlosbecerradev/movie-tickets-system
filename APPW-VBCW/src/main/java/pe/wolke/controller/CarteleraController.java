package pe.wolke.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.wolke.model.entity.Pelicula;
import pe.wolke.model.service.IPeliculaService;
import pe.wolke.model.service.IProyeccionService;
import pe.wolke.model.service.ITarifaService;

@Controller
public class CarteleraController {
	
	@Autowired
	@Qualifier("peliculaServiceImpl")
	private IPeliculaService peliculaService;
	
	@Autowired
	@Qualifier("proyeccionServiceImpl")
	private IProyeccionService proyeccionService;
	
	@Autowired
	@Qualifier("tarifaServiceImpl")
	private ITarifaService tarifaService;
	
	@RequestMapping(value = {"/cartelera", "/"}, method = RequestMethod.GET)
	public String cartelera_GET(Model model, @RequestParam(value="id" ,required = false) Integer id_pelicula) {
		
		model.addAttribute("Peliculas", peliculaService.findAllAvilable());	
		model.addAttribute("Tarifas", tarifaService.findAll());
		
		if (id_pelicula != null && id_pelicula > 0 && peliculaService.isExist(id_pelicula)) {		
			
			// Buscando pelicula seleccionada y mandando sus proyecciones
			Pelicula pelicula = peliculaService.findById(id_pelicula);
			model.addAttribute("pelicula", pelicula);
			// Listar proyecciones de pelicula seleccionada
			
			// Proyecciones de Hoy
			model.addAttribute("ProyeccionesHoy", proyeccionService.findAllByToday(pelicula.getItemsProyeccion()));
			
			// Proyecciones de Mañana			
			model.addAttribute("ProyeccionesManiana", proyeccionService.findAllByTomorrow(pelicula.getItemsProyeccion()));
			
		}
				
		return "cartelera";
	}
	
		

}
