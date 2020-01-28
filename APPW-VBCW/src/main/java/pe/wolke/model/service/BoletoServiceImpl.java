package pe.wolke.model.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IBoletoDao;
import pe.wolke.model.entity.Boleto;

@Service
public class BoletoServiceImpl implements IBoletoService {

	@Autowired
	private IBoletoDao boletoDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Boleto boleto) {
		boletoDao.save(boleto);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Boleto boleto) {
		boletoDao.save(boleto);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_boleto) {
		boletoDao.delete(findById(id_boleto));
	}

	@Override
	@Transactional(readOnly = true)
	public Boleto findById(Integer id_boleto) {				
		return boletoDao.findById(id_boleto).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Boleto> findAll() {
		return boletoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_boleto) {
		return boletoDao.existsById(id_boleto);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Boleto> findByFecha(Date fecha) {
		// TODO Auto-generated method stub
		return boletoDao.findByFecha(fecha);
	}

}
