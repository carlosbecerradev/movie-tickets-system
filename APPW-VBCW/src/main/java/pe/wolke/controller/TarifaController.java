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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.wolke.model.entity.Tarifa;
import pe.wolke.model.service.ITarifaService;

@Controller
public class TarifaController {

	@Autowired
	@Qualifier("tarifaServiceImpl")
	private ITarifaService tarifaService;	
	
	/* Listar */
	@RequestMapping(value = "/gestion_tarifas", method = RequestMethod.GET)
	public String listar_crear_tarifas_GET(Model model, @RequestParam(required = false) Integer id,
											@RequestParam(value="file",required = false) MultipartFile foto) {
				
		model.addAttribute("Tarifas", tarifaService.findAll());
		Tarifa tarifa = new Tarifa();
		
		if (id != null && id > 0) {
			tarifa = tarifaService.findById(id);
		}
		
		model.addAttribute("tarifa", tarifa);		
		return "gestion_tarifas";
	}
	

	/* Registrar o Editar */
	@RequestMapping(value = "/gestion_tarifas", method = RequestMethod.POST)
	public String registrar_tarifas_POST(@Valid Tarifa tarifa, BindingResult result, 
											@RequestParam(value="id" ,required = false) Integer id_tarifa, 
											RedirectAttributes flash,
											Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("Tarifas", tarifaService.findAll());
			return "gestion_tarifas";
		}
			
		
		if (id_tarifa != null && id_tarifa > 0) {
			tarifaService.update(tarifa);
			flash.addFlashAttribute("success", "Tarifa Editada con exito");
		} else {
			tarifaService.insert(tarifa);		
			flash.addFlashAttribute("success", "Tarifa Registrada con exito");	
		}
		
		
		return "redirect:/gestion_tarifas";
	}
	
	/* Eliminar */
	@RequestMapping(value = "/eliminar_tarifa/{id}")
	public String eliminar_tarifas(@PathVariable(value="id") Integer id_tarifa, RedirectAttributes flash) {
		
		if (id_tarifa != null && id_tarifa > 0 
				&& tarifaService.findById(id_tarifa).getItemsDetalleBoleto().size() == 0 ) 
		{
			tarifaService.delete(id_tarifa);
			flash.addFlashAttribute("success", "Tarifa Eliminada con exito");
		} 
		else 
		{
			flash.addFlashAttribute("error", "El id no exite o esta tarifa esta siendo usada.");
		}
		
		return "redirect:/gestion_tarifas";
	}
	
}
