package pe.wolke.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IProyeccionDao;
import pe.wolke.model.entity.Pelicula;
import pe.wolke.model.entity.Proyeccion;

@Service
public class ProyeccionServiceImpl implements IProyeccionService {

	@Autowired
	private IProyeccionDao proyeccionDao;
	
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Proyeccion proyeccion) {
		// TODO Auto-generated method stub
		proyeccionDao.save(proyeccion);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Proyeccion proyeccion) {
		// TODO Auto-generated method stub
		proyeccionDao.save(proyeccion);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_proyeccion) {
		// TODO Auto-generated method stub
		proyeccionDao.delete(findById(id_proyeccion));
	}

	@Override
	@Transactional(readOnly = true)
	public Proyeccion findById(Integer id_proyeccion) {
		// TODO Auto-generated method stub
		return proyeccionDao.findById(id_proyeccion).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Proyeccion> findAll() {
		// TODO Auto-generated method stub
		return proyeccionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_proyeccion) {
		// TODO Auto-generated method stub
		return proyeccionDao.existsById(id_proyeccion);
	}

	@Override
	public Collection<Proyeccion> filterProyeccionByDate(String fecha, Collection<Proyeccion> lstProyecciones) {
		
		Collection<Proyeccion> lstAuxiliar = new ArrayList<Proyeccion>();
		
		for(Proyeccion proy: lstProyecciones) {
			if (formatearFecha(proy.getFecha()).equals(fecha)) {
				lstAuxiliar.add(proy);
			}
		}
		return lstAuxiliar;
	}


	@Override
	public Collection<Proyeccion> findAllByToday(Collection<Proyeccion> lstProyecciones) {
		// TODO Auto-generated method stub
		return filterProyeccionByDate(formatearFecha(fechaActual()), lstProyecciones);
	}

	@Override
	public Collection<Proyeccion> findAllByTomorrow(Collection<Proyeccion> lstProyecciones) {
		// TODO Auto-generated method stub
		return filterProyeccionByDate(formatearFecha(fechaManiana()), lstProyecciones);
	}

	public Date fechaActual() {
		GregorianCalendar fechaG = new GregorianCalendar();
		Date fecha = fechaG.getTime();
		return fecha;
	}
	
	public Date fechaManiana() {
		GregorianCalendar fechaG = new GregorianCalendar();
		fechaG.add(Calendar.DAY_OF_MONTH, 1);
		Date fecha = fechaG.getTime();
		return fecha;
	}
	
	private String formatearFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = sdf.format(fecha);
        return fechaActual;
	}


}
