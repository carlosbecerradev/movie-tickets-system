package pe.wolke.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "detalle_boleto")
public class DetalleBoleto implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_tarifa")
    private Tarifa tarifa;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_boleto")
    private Boleto boleto;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false, columnDefinition = "decimal(6,2)")
    private Double importe;
 
    public DetalleBoleto() {
		// TODO Auto-generated constructor stub
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
    
}
