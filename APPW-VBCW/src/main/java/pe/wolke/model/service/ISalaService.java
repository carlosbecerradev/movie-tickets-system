package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.Sala;;

public interface ISalaService {
	public abstract void insert(Sala sala);
	public abstract void update(Sala sala);
	public abstract void delete(Integer id_sala);
	
	public abstract Sala findById(Integer id_sala);
	public abstract Collection<Sala> findAll();
	public abstract boolean isExist(Integer id_sala);
	

	public abstract void insertButacas(Sala sala);
}
