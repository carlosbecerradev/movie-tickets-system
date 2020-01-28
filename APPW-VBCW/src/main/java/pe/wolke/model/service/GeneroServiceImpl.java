package pe.wolke.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IGeneroDao;
import pe.wolke.model.entity.Genero;;

@Service
public class GeneroServiceImpl implements IGeneroService {

	@Autowired
	private IGeneroDao generoDao;

	@Override
	@Transactional(readOnly = true)
	public Collection<Genero> findAll() {
		return generoDao.findAll();
	}

}
