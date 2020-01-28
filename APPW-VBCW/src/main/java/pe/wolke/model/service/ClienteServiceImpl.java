package pe.wolke.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IClienteDao;
import pe.wolke.model.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	@Qualifier("clienteDaoImpl")
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Cliente cliente) {
		// TODO Auto-generated method stub		
		clienteDao.insert(cliente);
	}

}
