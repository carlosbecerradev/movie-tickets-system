package pe.wolke.model.dao;

import java.util.Collection;

import pe.wolke.model.entity.Butaca;

public interface ButacaDao {

	public abstract Collection<Butaca> findAllByIdSala(Integer id_sala);
}
