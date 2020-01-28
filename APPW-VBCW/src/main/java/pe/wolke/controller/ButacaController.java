package pe.wolke.controller;

import java.util.ArrayList;
import java.util.Collection;

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

import pe.wolke.model.entity.Butaca;
import pe.wolke.model.service.IButacaService;
import pe.wolke.model.service.ISalaService;



@Controller
public class ButacaController {

	@Autowired
	@Qualifier("butacaServiceImpl")
	private IButacaService butacaService;	
	
	@Autowired
	@Qualifier("salaServiceImpl")
	private ISalaService salaService;
	
	
	/* Listar */
	@RequestMapping(value = "/gestion_butacas", method = RequestMethod.GET)
	public String butacas_GET(Model model, @RequestParam(required = false) Integer id) {
		
		model.addAttribute("Butacas", butacaService.findAll());
		model.addAttribute("Salas", salaService.findAll());
		
		String [] lstFilas = {"A","B","C","D","E","F","G"};
		String [] lstColumnas = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
		model.addAttribute("lstFilas", lstFilas);
		model.addAttribute("lstColumnas", lstColumnas);
		
		Butaca butaca = new Butaca();
		
		if (id != null && id > 0) {
			butaca = butacaService.findById(id);
		}
		
		model.addAttribute("butaca", butaca);		
		return "gestion_butacas";
	}
	

	/* Registrar o Editar */
	@RequestMapping(value = "/gestion_butacas", method = RequestMethod.POST)
	public String registrar_butacas_POST(@Valid Butaca butaca, BindingResult result, 
											@RequestParam(value="id" ,required = false) Integer id_butaca, 
											RedirectAttributes flash, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("Butacas", butacaService.findAll());
			model.addAttribute("Salas", salaService.findAll());

			String [] lstFilas = {"A","B","C","D","E","F","G"};
			String [] lstColumnas = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
			model.addAttribute("lstFilas", lstFilas);
			model.addAttribute("lstColumnas", lstColumnas);
			
			return "gestion_butacas";
		}							
		
		if (id_butaca != null && id_butaca > 0) {
			butacaService.update(butaca);
			flash.addFlashAttribute("success", "Butaca Editada con exito");
		} else {
			butacaService.insert(butaca);		
			flash.addFlashAttribute("success", "Butaca Registrada con exito");	
		}		
		
		return "redirect:/gestion_butacas";
	}
	
	/* Eliminar */
	@RequestMapping(value = "/eliminar_butaca/{id}")
	public String eliminar_butacas(@PathVariable(value="id") Integer id_butaca, RedirectAttributes flash) {
		
		if (id_butaca != null && id_butaca > 0 
				&& butacaService.findById(id_butaca).getItemsReservaButaca().size() == 0) 
		{
			butacaService.delete(id_butaca);
			flash.addFlashAttribute("success", "Butaca Eliminada con exito");
		} 
		else 
		{
			flash.addFlashAttribute("error", "El id no exite o esta butaca está siendo usada");
		}
		
		return "redirect:/gestion_butacas";
	}	


}
