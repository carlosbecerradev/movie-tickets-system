package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.Cliente;

public interface IClienteService {
	public abstract void insert(Cliente cliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer id_cliente);
	
	public abstract Cliente findById(Integer id_cliente);
	public abstract Collection<Cliente> findAll();
	public abstract boolean isExist(Integer id_cliente);
}
