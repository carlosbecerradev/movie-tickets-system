package pe.wolke.model.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pe.wolke.model.entity.Butaca;

@Repository
public class ButacaDaoImpl implements ButacaDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Collection<Butaca> findAllByIdSala(Integer id_sala){
		Query query = entityManager.createNativeQuery("select * from butacas where id_sala = :id_sala ", Butaca.class);
		query.setParameter("id_sala", id_sala);
		return query.getResultList();
	}
}
