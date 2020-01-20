package pe.wolke.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IPeliculaDao;
import pe.wolke.model.entity.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	private IPeliculaDao peliculaDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaDao.save(pelicula);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaDao.save(pelicula);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_pelicula) {
		// TODO Auto-generated method stub
		peliculaDao.delete(findById(id_pelicula));
	}

	@Override
	@Transactional(readOnly = true)
	public Pelicula findById(Integer id_pelicula) {
		// TODO Auto-generated method stub
		return peliculaDao.findById(id_pelicula).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Pelicula> findAll() {
		// TODO Auto-generated method stub
		return peliculaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_pelicula) {
		// TODO Auto-generated method stub
		return peliculaDao.existsById(id_pelicula);
	}

	@Override
	public Collection<Pelicula> findAllAvilable() {
		// TODO Auto-generated method stub
		Collection<Pelicula> lst = peliculaDao.findAll();

		Predicate<Pelicula> streamsPredicate = item -> item.getEstado();
		
		return lst.stream().filter(streamsPredicate).collect(Collectors.toList());
	}

}
