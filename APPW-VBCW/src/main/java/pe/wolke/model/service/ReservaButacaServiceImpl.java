package pe.wolke.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IReservaButacaDao;
import pe.wolke.model.entity.ReservaButaca;

@Service
public class ReservaButacaServiceImpl implements IReservaButacaService {

	@Autowired
	@Qualifier("reservaButacaDaoImpl")
	private IReservaButacaDao reservaButacaDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(ReservaButaca reservaButaca) {
		// TODO Auto-generated method stub
		reservaButacaDao.insert(reservaButaca);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(ReservaButaca reservaButaca) {
		// TODO Auto-generated method stub
		reservaButacaDao.update(reservaButaca);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_reservaButaca) {
		// TODO Auto-generated method stub
		reservaButacaDao.delete(id_reservaButaca);
	}

	@Override
	@Transactional(readOnly = true)
	public ReservaButaca findById(Integer id_reservaButaca) {
		// TODO Auto-generated method stub
		return reservaButacaDao.findById(id_reservaButaca);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ReservaButaca> findAll() {
		// TODO Auto-generated method stub
		return reservaButacaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_reservaButaca) {
		// TODO Auto-generated method stub
		return reservaButacaDao.isExist(id_reservaButaca);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ReservaButaca> findAllByIdProyeccion(Integer id_proyeccion) {
		// TODO Auto-generated method stub
		return reservaButacaDao.findAllByIdProyeccion(id_proyeccion);
	}

}
