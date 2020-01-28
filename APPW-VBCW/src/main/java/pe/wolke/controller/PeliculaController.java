package pe.wolke.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.wolke.model.entity.Pelicula;
import pe.wolke.model.service.IGeneroService;
import pe.wolke.model.service.IPeliculaService;

@Controller
public class PeliculaController {

	@Autowired
	@Qualifier("peliculaServiceImpl")
	private IPeliculaService peliculaService;
	
	@Autowired
	@Qualifier("generoServiceImpl")
	private IGeneroService generoService;
	
	/* Listar */
	@RequestMapping(value = "/gestion_peliculas", method = RequestMethod.GET)
	public String listar_crear_peliculas_GET(Model model, @RequestParam(required = false) Integer id,
											@RequestParam(value="file",required = false) MultipartFile foto)
	{				
		model.addAttribute("Generos", generoService.findAll());
		model.addAttribute("Peliculas", peliculaService.findAll());
		
		Pelicula pelicula = new Pelicula();
		
		if (id != null && id > 0) {
			pelicula = peliculaService.findById(id);
		}
		
		model.addAttribute("pelicula", pelicula);		
		return "gestion_peliculas";
	}
	

	/* Registrar o Editar */
	@RequestMapping(value = "/gestion_peliculas", method = RequestMethod.POST)
	public String registrar_peliculas_POST(@Valid Pelicula pelicula, BindingResult result, 
											@RequestParam(value="id" ,required = false) Integer id_pelicula, 
											RedirectAttributes flash,
											@RequestParam(value="file",required = false) MultipartFile foto, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("Generos", generoService.findAll());
			model.addAttribute("Peliculas", peliculaService.findAll());
			return "gestion_peliculas";
		}
		
		if(!foto.isEmpty()) {
			Path directorioRescuros = Paths.get("src//main//resources//static//uploads");
			String rootPath = directorioRescuros.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Se subio correctamente '" + foto.getOriginalFilename() + "'");
				pelicula.setImagenUri("uploads/" + foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}			
			
		
		if (id_pelicula != null && id_pelicula > 0) {
			peliculaService.update(pelicula);
			flash.addFlashAttribute("success", "Película Editada con exito");
		} else {
			peliculaService.insert(pelicula);		
			flash.addFlashAttribute("success", "Película Registrada con exito");	
		}
		
		
		return "redirect:/gestion_peliculas";
	}
	
	/* Eliminar */
	@RequestMapping(value = "/eliminar_pelicula/{id}")
	public String eliminar_peliculas(@PathVariable(value="id") Integer id_pelicula, RedirectAttributes flash) {
		
		if (id_pelicula != null && id_pelicula > 0 
				&& peliculaService.findById(id_pelicula).getItemsProyeccion().size() == 0) 
		{				
			peliculaService.delete(id_pelicula);
			flash.addFlashAttribute("success", "Película Eliminada con exito");			
		} 
		else 
		{
			flash.addFlashAttribute("error", "El id no exite o esta pelicula está siendo usada");
		}
		
		return "redirect:/gestion_peliculas";
	}
		
	
}
