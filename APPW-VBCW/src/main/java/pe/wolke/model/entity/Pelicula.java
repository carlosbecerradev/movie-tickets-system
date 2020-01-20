package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(nullable = false, length = 30)
    private String titulo;

    @NotEmpty
    @Column(nullable = false, length = 1024)
    private String descripcion;

    @NotEmpty
    @Column(nullable = true, length = 255)
    private String imagenUri;

    @NotEmpty
    @Column(nullable = true, columnDefinition = "char(4)")
    private String censura;

    @NotEmpty
    @Column(nullable = true, length = 15)
    private String genero;

    @NotEmpty
    @Column(nullable = true, columnDefinition = "char(3)") 
    private String duracion; //minutos
    
    @NotNull
    @Column(nullable = false, columnDefinition = "bit default 1")
    private Boolean estado;  
    
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "timestamp default now()")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "timestamp")
    private Date updated_at;
    
    /* Union PELICULA TO PROYECCION */
    @OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER)    
    private Collection<Proyeccion> itemsProyeccion = new ArrayList<Proyeccion>();
    
    public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenUri() {
		return imagenUri;
	}

	public void setImagenUri(String imagenUri) {
		this.imagenUri = imagenUri;
	}

	public String getCensura() {
		return censura;
	}

	public void setCensura(String censura) {
		this.censura = censura;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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
            
}
