package pe.wolke.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IButacaDao;
import pe.wolke.model.entity.Butaca;

@Service
public class ButacaServiceImpl implements IButacaService {

	@Autowired
	private IButacaDao butacaDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Butaca butaca) {
		butacaDao.save(butaca);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Butaca butaca) {
		butacaDao.save(butaca);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_butaca) {
		butacaDao.delete(findById(id_butaca));
	}

	@Override
	@Transactional(readOnly = true)
	public Butaca findById(Integer id_butaca) {
		return butacaDao.findById(id_butaca).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Butaca> findAll() {
		// TODO Auto-generated method stub
		return butacaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_butaca) {
		// TODO Auto-generated method stub
		return butacaDao.existsById(id_butaca);
	}

}
