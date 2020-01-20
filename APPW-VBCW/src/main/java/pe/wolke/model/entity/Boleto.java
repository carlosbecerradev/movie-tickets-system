package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
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
    private Date fecha;
    @Column(nullable = false, columnDefinition = "decimal(7,2)")
    private Double monto_final;
    
    /* Union BOLETO TO DETALLE_BOLETO */
    @OneToMany(mappedBy = "boleto")
    private Set<DetalleBoleto> itemsDetalleBoleto = new HashSet<DetalleBoleto>();
    
    /* Union BOLETO TO RESERVA_BUTACA **/
    @OneToMany(mappedBy = "boleto")
    private Set<ReservaButaca> itemsReservaButaca = new HashSet<ReservaButaca>();
    
    /* Union CLIENTE TO BOLETO ***/
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

	public Set<DetalleBoleto> getItemsDetalleBoleto() {
		return itemsDetalleBoleto;
	}

	public void setItemsDetalleBoleto(Set<DetalleBoleto> itemsDetalleBoleto) {
		this.itemsDetalleBoleto = itemsDetalleBoleto;
	}

	public Set<ReservaButaca> getItemsReservaButaca() {
		return itemsReservaButaca;
	}

	public void setItemsReservaButaca(Set<ReservaButaca> itemsReservaButaca) {
		this.itemsReservaButaca = itemsReservaButaca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
        
}
