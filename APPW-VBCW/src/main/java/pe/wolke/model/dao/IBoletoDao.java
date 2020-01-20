package pe.wolke.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.wolke.model.entity.Boleto;

public interface IBoletoDao extends JpaRepository<Boleto, Integer> {

}
