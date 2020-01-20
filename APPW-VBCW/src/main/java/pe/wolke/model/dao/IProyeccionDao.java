package pe.wolke.model.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.wolke.model.entity.Proyeccion;

public interface IProyeccionDao extends JpaRepository<Proyeccion, Integer> {

}
