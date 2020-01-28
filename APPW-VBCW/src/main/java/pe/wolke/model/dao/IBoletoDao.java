package pe.wolke.model.dao;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.wolke.model.entity.Boleto;

public interface IBoletoDao extends JpaRepository<Boleto, Integer> {

	@Query("select b from Boleto b where b.fecha = ?1")
	public abstract Collection<Boleto> findByFecha(Date fecha);
	
}
