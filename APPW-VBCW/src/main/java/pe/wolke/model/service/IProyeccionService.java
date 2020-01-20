package pe.wolke.model.service;

import java.util.Collection;
import java.util.Date;

import pe.wolke.model.entity.Proyeccion;;

public interface IProyeccionService {
	
	public abstract void insert(Proyeccion proyeccion);
	public abstract void update(Proyeccion proyeccion);
	public abstract void delete(Integer id_proyeccion);
	
	public abstract Proyeccion findById(Integer id_proyeccion);
	public abstract Collection<Proyeccion> findAll();
	public abstract boolean isExist(Integer id_proyeccion);
	
	/**/
	
	public abstract Collection<Proyeccion> filterProyeccionByDate(String fecha, Collection<Proyeccion> lstProyecciones);
	public abstract Collection<Proyeccion> findAllByToday(Collection<Proyeccion> lstProyecciones);
	public abstract Collection<Proyeccion> findAllByTomorrow(Collection<Proyeccion> lstProyecciones);
}
