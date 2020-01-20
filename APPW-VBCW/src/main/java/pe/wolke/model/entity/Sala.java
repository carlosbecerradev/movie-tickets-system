package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "salas")
public class Sala implements Serializable{
    
    @Id
    @GeneratedValue()
    private Integer id;
    
    @NotEmpty
    @Column(nullable = false, unique = true, columnDefinition = "char(8)")
    private String nombre;    
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "timestamp default now()")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "timestamp")
    private Date updated_at;

    /* Union SALA TO PROYECCION */
    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER)
    private Collection<Proyeccion> itemsProyeccion = new ArrayList<Proyeccion>();
    
    /* Union SALA TO BUTACA */
    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)    
    private Collection<Butaca> itemsButacas = new ArrayList<Butaca>();
    
    public Sala() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Collection<Proyeccion> getItemsProyeccion() {
		return itemsProyeccion;
	}

	public void setItemsProyeccion(Collection<Proyeccion> itemsProyeccion) {
		this.itemsProyeccion = itemsProyeccion;
	}

	public Collection<Butaca> getItemsButacas() {
		return itemsButacas;
	}

	public void setItemsButacas(Collection<Butaca> itemsButacas) {
		this.itemsButacas = itemsButacas;
	}
    
}
