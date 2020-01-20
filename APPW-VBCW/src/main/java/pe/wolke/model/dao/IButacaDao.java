package pe.wolke.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.wolke.model.entity.Butaca;

public interface IButacaDao extends JpaRepository<Butaca, Integer> {

}
