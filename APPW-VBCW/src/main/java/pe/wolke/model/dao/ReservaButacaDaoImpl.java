package pe.wolke.model.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pe.wolke.model.entity.ReservaButaca;

@Repository
public class ReservaButacaDaoImpl implements IReservaButacaDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(ReservaButaca reservaButaca) {
		// TODO Auto-generated method stub
		entityManager.persist(reservaButaca);
	}

	@Override
	public void update(ReservaButaca reservaButaca) {
		// TODO Auto-generated method stub
		entityManager.merge(reservaButaca);
	}

	@Override
	public void delete(Integer id_reservaButaca) {
		// TODO Auto-generated method stub
		entityManager.remove(findById(id_reservaButaca));
	}

	@Override
	public ReservaButaca findById(Integer id_reservaButaca) {
		// TODO Auto-generated method stub
		return entityManager.find(ReservaButaca.class, id_reservaButaca);
	}

	@Override
	public Collection<ReservaButaca> findAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("select * from reserva_butaca", ReservaButaca.class);
		return query.getResultList();
	}

	@Override
	public boolean isExist(Integer id_reservaButaca) {
		// TODO Auto-generated method stub
		return entityManager.contains(findById(id_reservaButaca));
	}

	@Override
	public Collection<ReservaButaca> findAllByIdProyeccion(Integer id_proyeccion) {
		Query query = entityManager.createNativeQuery("select * from reserva_butaca where id_proyeccion = :id_proyeccion order by id_butaca", ReservaButaca.class);
		query.setParameter("id_proyeccion", id_proyeccion);
		return query.getResultList();
	}

}
