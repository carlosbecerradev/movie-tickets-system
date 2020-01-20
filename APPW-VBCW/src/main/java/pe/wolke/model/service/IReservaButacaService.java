package pe.wolke.model.service;

import java.util.Collection;

import pe.wolke.model.entity.ReservaButaca;;

public interface IReservaButacaService {
	public abstract void insert(ReservaButaca reservaButaca);
	public abstract void update(ReservaButaca reservaButaca);
	public abstract void delete(Integer id_reservaButaca);
	
	public abstract ReservaButaca findById(Integer id_reservaButaca);
	public abstract Collection<ReservaButaca> findAll();
	public abstract boolean isExist(Integer id_reservaButaca);
}
