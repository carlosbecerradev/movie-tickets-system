package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tarifas")
public class Tarifa implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(nullable = false, length = 20)
    private String tipo_cliente;
    
    @NotEmpty    
    @Column(nullable = false, length = 2, columnDefinition = "char(2)")
    private String calidad;
    
    @NotNull
    @Column(nullable = false, columnDefinition = "decimal(5,2)")
    private Double precio;    
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "timestamp default now()")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "timestamp")
    private Date updated_at;
    
    /*Union*/
    @OneToMany(mappedBy = "tarifa", fetch = FetchType.EAGER)
    private Collection<DetalleBoleto> itemsDetalleBoleto = new ArrayList<DetalleBoleto>();
    
    public Tarifa() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Collection<DetalleBoleto> getItemsDetalleBoleto() {
		return itemsDetalleBoleto;
	}

	public void setItemsDetalleBoleto(Collection<DetalleBoleto> itemsDetalleBoleto) {
		this.itemsDetalleBoleto = itemsDetalleBoleto;
	}
    
}