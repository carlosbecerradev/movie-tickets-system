package pe.wolke.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.wolke.model.entity.Boleto;
import pe.wolke.model.entity.Cliente;
import pe.wolke.model.entity.DetalleBoleto;
import pe.wolke.model.entity.Proyeccion;
import pe.wolke.model.entity.ReservaButaca;
import pe.wolke.model.entity.Tarifa;
import pe.wolke.model.service.IBoletoService;
import pe.wolke.model.service.IClienteService;
import pe.wolke.model.service.IDetalleBoletoService;
import pe.wolke.model.service.IProyeccionService;
import pe.wolke.model.service.IReservaButacaService;
import pe.wolke.model.service.ITarifaService;
import pe.wolke.model.service.SendMailService;

@Controller
public class CompraBoletoController {
	
	@Autowired
	@Qualifier("proyeccionServiceImpl")
	private IProyeccionService proyeccionService;
	
	@Autowired
	@Qualifier("tarifaServiceImpl")
	private ITarifaService tarifaService;
	
	@Autowired
	@Qualifier("reservaButacaServiceImpl")
	private IReservaButacaService reservaButacaService;	
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("boletoServiceImpl")
	private IBoletoService boletoService;
	
	@Autowired
	@Qualifier("detalleBoletoServiceImpl")
	private IDetalleBoletoService detalleBoletoService;
	
	private Proyeccion proyeccion;
	private Boleto boleto;
	private Cliente cliente;
	
	@GetMapping(value = "/compra_boleto")
	public String compra_boleto_list_GET(@RequestParam(value="id") Integer id_proyeccion, Model model) {
		
		if (id_proyeccion != null && id_proyeccion >0 && proyeccionService.isExist(id_proyeccion)) {

			/* Enviar proyeccion seleccionada por el cliente */
			this.proyeccion = proyeccionService.findById(id_proyeccion);
			model.addAttribute("proyeccion", this.proyeccion);
			
			/* Filtrar tarifas con la calidad igual al de la pelicula*/
			Collection<Tarifa> lstTarifa = new ArrayList();
			for(Tarifa tarifa:tarifaService.findAll()) {
				if (tarifa.getCalidad().equals(proyeccion.getCalidad())) {
					lstTarifa.add(tarifa);
				}
			}
			model.addAttribute("tarifas", lstTarifa);		
			/* Mostrar butacas de la sala */
			model.addAttribute("reservasByProyeccion", reservaButacaService.findAllByIdProyeccion(id_proyeccion));
			
			this.boleto = new Boleto();
			Cliente cliente = new Cliente();
			model.addAttribute("cliente", cliente);
		}
		
		return "compra_boleto";
	}

	
	@PostMapping(value = "/compra_boleto")
	public String compra_boleto_list_POST(@Valid Cliente cliente, BindingResult result, Model model, 
			@RequestParam(value="id", required =false) Integer id_proyeccion,
			@RequestParam(name = "id_tarifa", required =false) Integer[] id_tarifa,
			@RequestParam(name = "cantidad", required =false) Integer[] cantidad,
			@RequestParam(name = "id_reserva_butaca", required =false) Integer[] idReservaButaca,
			RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			flash.addFlashAttribute("error", "Rellene todos los campos porfavor");	
			return "redirect:/compra_boleto?id=".concat(String.valueOf(id_proyeccion));
		}	
		
		if(id_proyeccion != null && id_tarifa != null && cantidad != null && idReservaButaca != null) {
			
			/*  Creando detalle del boleto en memoria */
			Collection<DetalleBoleto> itemsDetalleBoleto = new ArrayList<DetalleBoleto>();		
			for (int i = 0; i < cantidad.length; i++) {
				if (cantidad[i] > 0) {
					DetalleBoleto detalle = new DetalleBoleto();
					Tarifa tarifa = tarifaService.findById(id_tarifa[i]);
					detalle.setTarifa(tarifa);
					detalle.setCantidad(cantidad[i]);
					detalle.setImporte(tarifa.getPrecio()*cantidad[i]);
					itemsDetalleBoleto.add(detalle);
				}			
			}
			Collection<ReservaButaca> itemsReservaButaca = new ArrayList<ReservaButaca>();		
			for (int i = 0; i < idReservaButaca.length; i++) {
				ReservaButaca reserva = reservaButacaService.findById(idReservaButaca[i]);
				reserva.setEstado(true);
				itemsReservaButaca.add(reserva);
			}
			
			/* Creando Boleto en memoria */
			this.cliente = cliente;
			this.boleto.setCliente(this.cliente);
			this.boleto.setItemsDetalleBoleto(itemsDetalleBoleto);
			this.boleto.setItemsReservaButaca(itemsReservaButaca);
			Double montoFinal = 0.0;
			for(DetalleBoleto dt: itemsDetalleBoleto) {
				montoFinal = montoFinal + dt.getImporte();
			}
			this.boleto.setMonto_final(montoFinal);
			
		} else {
			flash.addFlashAttribute("error", "Rellene todos los campos porfavor");	
			return "redirect:/compra_boleto?id=".concat(String.valueOf(id_proyeccion));
		}
		
		return "redirect:/pagar_boleto";
	}
	
	@GetMapping(value = "/pagar_boleto")
	public String pagar_boleto_GET(Model model) {
		
		/* Enviar proyeccion seleccionada por el cliente */
		model.addAttribute("proyeccion", this.proyeccion);
		
		int numeroButacas = this.boleto.getItemsReservaButaca().size();		
		model.addAttribute("numeroButacas", numeroButacas);
		
		/* Enviando butacas seleccionadas */		
		model.addAttribute("butacasSeleccionadas", this.boleto.getItemsReservaButaca());
		
		/*Enviando monto Final*/
		model.addAttribute("montoFinal", this.boleto.getMonto_final());
		
		return "pagar_boleto";
	}
	
	@Autowired
	private SendMailService sendMailService;
		
	@RequestMapping(value = "/pagar_boleto", method = RequestMethod.POST)
	public String pagar_boleto_POST(RedirectAttributes flash) {
		
		this.cliente.setId(null);
		clienteService.insert(this.cliente);		
		this.boleto.setFecha(new Date());
		
		/* Actualizando las reservas */
		boletoService.insert(this.boleto);
		for(ReservaButaca rb : this.boleto.getItemsReservaButaca()) {
			rb.setBoleto(this.boleto);
			rb.setEstado(true);
			reservaButacaService.update(rb);
		}
		/* Insertando el detalle del boleto */
		for(DetalleBoleto dt: this.boleto.getItemsDetalleBoleto()) {
			dt.setBoleto(this.boleto);
			detalleBoletoService.insert(dt);
		}
		
		String correoEmpresa = "cinewolke.app@gmail.com";
		String cooreoCliente = this.cliente.getCorreo();
		String asunto = "CineWolke - Compra de Boleto";
		String mensaje = sendMailService.generarMensaje(this.boleto);
		
		/* Enviar mensaje a correo electrónico */
		sendMailService.sendMail(
				correoEmpresa, 
				cooreoCliente, 
				asunto, 
				mensaje);
		
		this.cliente = null;
		this.boleto = null;
		this.proyeccion = null;
		flash.addFlashAttribute("success", "Boleto comprado con exito");
		
		return "redirect:/cartelera";
	}
	
	@RequestMapping(value="/cancelar_compra")
	public String cancelar_compra_GET() {
		this.cliente = null;
		this.boleto = null;		
		this.proyeccion = null;
		return "redirect:/cartelera";
	}
	
	

}
