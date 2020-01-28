package pe.wolke.model.dao;

import org.springframework.data.repository.CrudRepository;

import pe.wolke.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

	public Usuario findByUsername(String username);
	
}
