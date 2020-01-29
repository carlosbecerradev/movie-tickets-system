package pe.wolke.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pe.wolke.model.entity.Boleto;
import pe.wolke.model.entity.DetalleBoleto;
import pe.wolke.model.entity.ReservaButaca;

@Service
public class SendMailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String from, String to, String subject, String body)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		javaMailSender.send(mailMessage);
	}
	
	public String generarMensaje(Boleto boleto) 
	{		
		String mensaje = "", posicionButcas = "", tiposClientes = "";
		
		for(ReservaButaca rb: boleto.getItemsReservaButaca()) {
			posicionButcas = posicionButcas + " | " + rb.getButaca().getFila() +rb.getButaca().getColumna();
		}
		
		for(DetalleBoleto db: boleto.getItemsDetalleBoleto()) {
			tiposClientes = tiposClientes + "\t" + db.getTarifa().getTipo_cliente() + ": " + db.getCantidad() + "\n";
		}
		
		
		mensaje = boleto.getCliente().getNombres() + " "+ boleto.getCliente().getApellidos() + 
				", gracias por realizar su compra."
				.concat("\n\nDatos del boleto comprado:")
				.concat("\nPelicula: " + boleto.getProyeccion().getPelicula().getTitulo())
				.concat("\nFecha de Proyección: " + boleto.getProyeccion().getFecha())
				.concat("\nHora de Proyección: " + boleto.getProyeccion().getHora())
				.concat("\nCalidad de Proyección: " + boleto.getProyeccion().getCalidad())
				.concat("\nIdioma de Proyección: " + boleto.getProyeccion().getIdioma())
				
				.concat("\n\nCantidad de Butacas: " + boleto.getItemsReservaButaca().size())
				.concat("\nPosición de Butacas: ")
				.concat("\n" + posicionButcas)
				.concat("\n\nTipos de Clientes: ")
				.concat("\n" + tiposClientes)
				.concat("\nMonto Final: ")
				.concat("\n" + boleto.getMonto_final())
				.concat("\n\nEstado de Boleto : Cancelado")
				;
		
		return mensaje;
	}
	
}
