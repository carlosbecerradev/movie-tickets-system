package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "boletos")
public class Boleto implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    @NotNull
    private Date fecha;
    
    @NotNull
    @Column(nullable = false, columnDefinition = "decimal(7,2)")
    private Double monto_final;
    
    /* Union BOLETO TO DETALLE_BOLETO */
    @OneToMany(mappedBy = "boleto")
    private Collection<DetalleBoleto> itemsDetalleBoleto = new ArrayList<DetalleBoleto>();
    
    /* Union BOLETO TO RESERVA_BUTACA **/
    @OneToMany(mappedBy = "boleto")
    private Collection<ReservaButaca> itemsReservaButaca = new ArrayList<ReservaButaca>();
    
    /* Union CLIENTE TO BOLETO ***/
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(
    		foreignKeyDefinition = "foreign key (id_cliente) references clientes(id)"))
    private Cliente cliente;
    
    public Boleto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMonto_final() {
		return monto_final;
	}

	public void setMonto_final(Double monto_final) {
		this.monto_final = monto_final;
	}

	public Collection<DetalleBoleto> getItemsDetalleBoleto() {
		return itemsDetalleBoleto;
	}

	public void setItemsDetalleBoleto(Collection<DetalleBoleto> itemsDetalleBoleto) {
		this.itemsDetalleBoleto = itemsDetalleBoleto;
	}

	public Collection<ReservaButaca> getItemsReservaButaca() {
		return itemsReservaButaca;
	}

	public void setItemsReservaButaca(Collection<ReservaButaca> itemsReservaButaca) {
		this.itemsReservaButaca = itemsReservaButaca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Proyeccion getProyeccion() {
		Proyeccion proyeccion = new Proyeccion();
		for(ReservaButaca rb: getItemsReservaButaca()){
			proyeccion = rb.getProyeccion();
		}
		return proyeccion;
	}
	
        
}
