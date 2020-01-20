package pe.wolke.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.wolke.model.entity.Boleto;
import pe.wolke.model.entity.Cliente;
import pe.wolke.model.entity.DetalleBoleto;
import pe.wolke.model.entity.Proyeccion;
import pe.wolke.model.entity.ReservaButaca;
import pe.wolke.model.entity.Tarifa;
import pe.wolke.model.service.IProyeccionService;
import pe.wolke.model.service.ITarifaService;

@Controller
public class CompraBoletoController {
	
	@Autowired
	@Qualifier("proyeccionServiceImpl")
	private IProyeccionService proyeccionService;
	
	@Autowired
	@Qualifier("tarifaServiceImpl")
	private ITarifaService tarifaService;
	
	private Boleto boleto;
	private Cliente cliente;
	private DetalleBoleto detalle;
	private ReservaButaca reserva;
	
	
	@GetMapping(value = "/compra_boleto")
	public String compra_boleto_list_GET(@RequestParam(value="id") Integer id_proyeccion, Model model) {
		
		/* Enviar proyeccion seleccionada por el cliente */
		Collection<Proyeccion> lstProyeccion = new ArrayList();
		Proyeccion proyeccion = proyeccionService.findById(id_proyeccion);
		lstProyeccion.add(proyeccion);
		model.addAttribute("proyeccion", lstProyeccion);
		
		/* Filtrar tarifas con la calidad igual al de la pelicula*/
		Collection<Tarifa> lstTarifa = new ArrayList();
		for(Tarifa tar:tarifaService.findAll()) {
			if (tar.getCalidad().equals(proyeccion.getCalidad())) {
				lstTarifa.add(tar);
			}
		}
		model.addAttribute("tarifas", lstTarifa);
		
		/*  */
		
		return "compra_boleto";
	}
	
	

}
