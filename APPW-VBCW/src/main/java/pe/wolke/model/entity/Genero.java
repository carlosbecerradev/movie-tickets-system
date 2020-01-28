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
@Table(name = "generos")
public class Genero implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(nullable = false, unique = true, length = 20)
	private String nombre;
	
	@OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
	private Collection<Pelicula> itemsPeliculas = new ArrayList<Pelicula>();
	
    
    public Genero() {
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


	public Collection<Pelicula> getItemsPeliculas() {
		return itemsPeliculas;
	}

	public void setItemsPeliculas(Collection<Pelicula> itemsPeliculas) {
		this.itemsPeliculas = itemsPeliculas;
	}        
	
}
