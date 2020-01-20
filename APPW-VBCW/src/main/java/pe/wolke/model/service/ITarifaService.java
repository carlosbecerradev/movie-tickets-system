package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.Tarifa;;

public interface ITarifaService {
	public abstract void insert(Tarifa tarifa);
	public abstract void update(Tarifa tarifa);
	public abstract void delete(Integer id_tarifa);
	
	public abstract Tarifa findById(Integer id_tarifa);
	public abstract Collection<Tarifa> findAll();
	public abstract boolean isExist(Integer id_tarifa);
}
