package pe.wolke.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "reserva_butaca")
public class ReservaButaca implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_butaca")
    private Butaca butaca;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_proyeccion")
    private Proyeccion proyeccion;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_boleto")
    private Boleto boleto;
    
    
    @Column(columnDefinition = "bit", nullable = false)
    private boolean estado;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "timestamp default now()")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "timestamp")
    private Date updated_at;
    
    public ReservaButaca() {
		// TODO Auto-generated constructor stub
	}

	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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
    
}

