package pe.wolke.model.service;

import java.util.Collection;
import pe.wolke.model.entity.Boleto;

public interface IBoletoService {
	
	public abstract void insert(Boleto boleto);
	public abstract void update(Boleto boleto);
	public abstract void delete(Integer id_boleto);
	
	public abstract Boleto findById(Integer id_boleto);
	public abstract Collection<Boleto> findAll();
	public abstract boolean isExist(Integer id_boleto);
	
}
