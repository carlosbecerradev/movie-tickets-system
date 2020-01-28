package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 15, unique = true)
	private String tipo;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
	private Collection<Usuario> itemsUsuario = new ArrayList();

    
	public Rol() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Collection<Usuario> getItemsUsuario() {
		return itemsUsuario;
	}

	public void setItemsUsuario(Collection<Usuario> itemsUsuario) {
		this.itemsUsuario = itemsUsuario;
	}


	
}
