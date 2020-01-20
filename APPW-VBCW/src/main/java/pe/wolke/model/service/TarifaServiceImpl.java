package pe.wolke.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.ITarifaDao;
import pe.wolke.model.entity.Tarifa;

@Service
public class TarifaServiceImpl implements ITarifaService {

	@Autowired
	private ITarifaDao tarifaDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Tarifa tarifa) {
		// TODO Auto-generated method stub
		tarifaDao.save(tarifa);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Tarifa tarifa) {
		// TODO Auto-generated method stub
		tarifaDao.save(tarifa);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_tarifa) {
		// TODO Auto-generated method stub
		tarifaDao.delete(findById(id_tarifa));
	}

	@Override
	@Transactional(readOnly = true)
	public Tarifa findById(Integer id_tarifa) {
		// TODO Auto-generated method stub
		return tarifaDao.findById(id_tarifa).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Tarifa> findAll() {
		// TODO Auto-generated method stub
		return tarifaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_tarifa) {
		// TODO Auto-generated method stub
		return tarifaDao.existsById(id_tarifa);
	}

}
