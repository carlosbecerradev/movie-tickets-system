package pe.wolke.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.wolke.model.entity.Boleto;
import pe.wolke.model.service.IBoletoService;
import pe.wolke.model.service.IPeliculaService;

@Controller
public class ReporteController {

	@Autowired
	@Qualifier("peliculaServiceImpl")
	private IPeliculaService peliculaService;
	
	@Autowired
	@Qualifier("boletoServiceImpl")
	private IBoletoService boletoService;
		
	@RequestMapping(value = "/reportes", method = RequestMethod.GET)
	public String reportes_GET(Model model, 
			@RequestParam(value = "id_pelicula", required = false) Integer id_pelicula,
			@RequestParam(value = "fecha", required = false) String fecha) throws ParseException{

		model.addAttribute("Peliculas", peliculaService.findAll());
		
		if (id_pelicula == null && fecha == null) {
			model.addAttribute("Boletos", boletoService.findAll());
		}
		
		if (id_pelicula != null && peliculaService.isExist(id_pelicula) ) {
			/* Burcas boletos que contengan la pelicula seleccionada*/
			Collection<Boleto> boletosByPelicula = new ArrayList<Boleto>();
			for(Boleto boleto: boletoService.findAll()) {
				if (boleto.getProyeccion().getPelicula() == peliculaService.findById(id_pelicula)) {					
					boletosByPelicula.add(boleto);					
				}
			}
			/* Quitar elementos repetidos */
			Set<Boleto> linkedHashSet = new LinkedHashSet<Boleto>();
			linkedHashSet.addAll(boletosByPelicula);
			boletosByPelicula.clear();
			boletosByPelicula.addAll(linkedHashSet);
			model.addAttribute("Boletos", boletosByPelicula);
		}
		
		if(fecha != null && fecha.length() == 10) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha_ = sdf.parse(fecha);
			model.addAttribute("Boletos", boletoService.findByFecha(fecha_));	
		}
		
		return "reportes";
	}

	
	@RequestMapping(value="/reportes_limpiar", method = RequestMethod.GET)
	public String reportes_limpiar() {
		return "redirect:/reportes";
	}
	
}
