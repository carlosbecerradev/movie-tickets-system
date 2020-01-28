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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.wolke.model.entity.Sala;
import pe.wolke.model.service.ISalaService;

@Controller
public class SalaController {
	
	@Autowired
	@Qualifier("salaServiceImpl")
	private ISalaService salaService;

	/* Listar */
	@RequestMapping(value = "/gestion_salas", method = RequestMethod.GET)
	public String salas_GET(Model model, @RequestParam(required = false) Integer id) {
		
		model.addAttribute("Salas", salaService.findAll());
		Sala sala = new Sala();
		
		if (id != null && id > 0) {
			sala = salaService.findById(id);
		}
		
		model.addAttribute("sala", sala);		
		return "gestion_salas";
	}
	

	/* Registrar o Editar */
	@RequestMapping(value = "/gestion_salas", method = RequestMethod.POST)
	public String registrar_salas_POST(@Valid Sala sala, BindingResult result, 
											@RequestParam(value="id" ,required = false) Integer id_sala, 
											RedirectAttributes flash, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("Salas", salaService.findAll());
			return "gestion_salas";
		}							
		
		if (id_sala != null && id_sala > 0) {
			salaService.update(sala);
			flash.addFlashAttribute("success", "Sala Editada con exito");
		} else {
			salaService.insert(sala);		
			flash.addFlashAttribute("success", "Sala Registrada con exito");	
		}		
		
		return "redirect:/gestion_salas";
	}
	
	/* Eliminar */
	@RequestMapping(value = "/eliminar_sala/{id}")
	public String eliminar_salas(@PathVariable(value="id") Integer id_sala, RedirectAttributes flash) {
		
		if (id_sala != null && id_sala > 0 
				&& salaService.findById(id_sala).getItemsProyeccion().size() == 0 
				&& salaService.findById(id_sala).getItemsButacas().size() == 0 ) 
		{
			salaService.delete(id_sala);
			flash.addFlashAttribute("success", "Sala Eliminada con exito");
		} 
		else
		{
			flash.addFlashAttribute("error", "El id no exite o esta sala esta siendo usada.");
		}
		
		return "redirect:/gestion_salas";
	}
	
}
