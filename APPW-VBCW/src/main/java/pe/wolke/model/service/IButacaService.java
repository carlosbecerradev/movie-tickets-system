package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.Butaca;

public interface IButacaService {
	public abstract void insert(Butaca butaca);
	public abstract void update(Butaca butaca);
	public abstract void delete(Integer id_butaca);
	
	public abstract Butaca findById(Integer id_butaca);
	public abstract Collection<Butaca> findAll();
	public abstract boolean isExist(Integer id_butaca);
}
