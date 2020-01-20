package pe.wolke.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IClienteDao;
import pe.wolke.model.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_cliente) {
		// TODO Auto-generated method stub
		clienteDao.delete(findById(id_cliente));
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Integer id_cliente) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id_cliente).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_cliente) {
		// TODO Auto-generated method stub
		return clienteDao.existsById(id_cliente);
	}

}
