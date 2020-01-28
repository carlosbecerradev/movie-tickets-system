package pe.wolke.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IDetalleBoletoDao;
import pe.wolke.model.entity.DetalleBoleto;

@Service
public class DetalleBoletoServiceImpl implements IDetalleBoletoService {

	@Autowired
	private IDetalleBoletoDao detalleBoletoDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(DetalleBoleto detalleBoleto) {
		// TODO Auto-generated method stub
		detalleBoletoDao.save(detalleBoleto);
	}

}
