package pe.wolke.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.wolke.model.entity.Tarifa;

public interface ITarifaDao extends JpaRepository<Tarifa, Integer> {

}
