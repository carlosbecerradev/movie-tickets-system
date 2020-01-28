package pe.wolke.model.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import pe.wolke.model.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Cliente cliente) {
		// TODO Auto-generated method stub
		entityManager.persist(cliente);
	}

}
