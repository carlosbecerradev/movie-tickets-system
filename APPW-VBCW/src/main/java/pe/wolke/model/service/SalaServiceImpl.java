package pe.wolke.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.ISalaDao;
import pe.wolke.model.entity.Sala;

@Service
public class SalaServiceImpl implements ISalaService {

	@Autowired
	private ISalaDao salaDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Sala sala) {
		// TODO Auto-generated method stub
		salaDao.save(sala);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Sala sala) {
		// TODO Auto-generated method stub
		salaDao.save(sala);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_sala) {
		// TODO Auto-generated method stub
		salaDao.delete(findById(id_sala));
	}

	@Override
	@Transactional(readOnly = true)
	public Sala findById(Integer id_sala) {
		// TODO Auto-generated method stub
		return salaDao.findById(id_sala).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Sala> findAll() {
		// TODO Auto-generated method stub
		return salaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_sala) {
		// TODO Auto-generated method stub
		return salaDao.existsById(id_sala);
	}

}
