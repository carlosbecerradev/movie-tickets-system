package pe.wolke.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.wolke.model.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {

}
