package pe.wolke.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.wolke.model.entity.Sala;

public interface ISalaDao extends JpaRepository<Sala, Integer> {

}
