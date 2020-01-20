package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.Pelicula;;

public interface IPeliculaService {
	public abstract void insert(Pelicula pelicula);
	public abstract void update(Pelicula pelicula);
	public abstract void delete(Integer id_pelicula);
	
	public abstract Pelicula findById(Integer id_pelicula);
	public abstract Collection<Pelicula> findAll();
	public abstract boolean isExist(Integer id_pelicula);
	
	/* */
	public abstract Collection<Pelicula> findAllAvilable();
}
