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
@Table(name = "butacas")
public class Butaca implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(nullable = false, columnDefinition = "char(1)")
    private Character fila;
    
    @NotEmpty
    @Column(nullable = false, columnDefinition = "char(2)")
    private String columna;
    
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
    
    /* Union BUTACA TO RESERVA_BUTACA*/
    @OneToMany(mappedBy = "butaca")
    private Collection<ReservaButaca> itemsReservaButaca = new ArrayList<ReservaButaca>();
    
    /*Union SALA TO BUTACA */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala", nullable = false, foreignKey = @ForeignKey(
    		foreignKeyDefinition = "foreign key (id_sala) references salas(id)"))
    private Sala sala;
    
    public Butaca() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getFila() {
		return fila;
	}

	public void setFila(Character fila) {
		this.fila = fila;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
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
	
	public Collection<ReservaButaca> getItemsReservaButaca() {
		return itemsReservaButaca;
	}

	public void setItemsReservaButaca(Collection<ReservaButaca> itemsReservaButaca) {
		this.itemsReservaButaca = itemsReservaButaca;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
    
}

