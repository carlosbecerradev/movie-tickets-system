package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.DetalleBoleto;;

public interface IDetalleBoletoService {
	public abstract void insert(DetalleBoleto detalleBoleto);
	public abstract void update(DetalleBoleto detalleBoleto);
	public abstract void delete(Integer id_detalleBoleto);
	
	public abstract DetalleBoleto findById(Integer id_detalleBoleto);
	public abstract Collection<DetalleBoleto> findAll();
	public abstract boolean isExist(Integer id_detalleBoleto);
}
