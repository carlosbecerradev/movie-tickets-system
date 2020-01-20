package pe.wolke.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import pe.wolke.model.entity.Pelicula;

public interface IPeliculaDao extends JpaRepository<Pelicula, Integer> {
		
	
}
