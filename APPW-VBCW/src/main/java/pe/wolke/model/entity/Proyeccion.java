package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "proyecciones")
public class Proyeccion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    private Date fecha;

    @NotEmpty
    @Column(nullable = false,columnDefinition = "char(5)")
    private String hora;
    
    @NotEmpty
    @Column(nullable = false, columnDefinition = "char(3)")
    private String idioma;
    
    @NotEmpty
    @Column(nullable = false, columnDefinition = "char(2)")
    private String calidad;
    
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
    
    /* Union PROYECCION TO RESERVA_BUTACA */
    @OneToMany(mappedBy = "proyeccion")
    private Set<ReservaButaca> itemsReservaButaca = new HashSet<ReservaButaca>();
    
    /* Union PELICULA TO PROYECCION */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pelicula", nullable = false, foreignKey = @ForeignKey(
    		foreignKeyDefinition = "foreign key (id_pelicula) references peliculas(id)"))
    private Pelicula pelicula;
    
    /* Union SALA TO PROYECCION ***/
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sala", nullable = false, foreignKey = @ForeignKey(
    		foreignKeyDefinition = "foreign key (id_sala) references salas(id)"))
    private Sala sala;    
    
    public Proyeccion() {
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
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

	public Set<ReservaButaca> getItemsReservaButaca() {
		return itemsReservaButaca;
	}

	public void setItemsReservaButaca(Set<ReservaButaca> itemsReservaButaca) {
		this.itemsReservaButaca = itemsReservaButaca;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
    
}