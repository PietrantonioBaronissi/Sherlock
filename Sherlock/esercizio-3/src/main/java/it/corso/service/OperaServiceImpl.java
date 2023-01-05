package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OperaDao;
import it.corso.model.Opera;

@Service
public class OperaServiceImpl implements OperaService{

	@Autowired
	private OperaDao operaDao;
	
	@Override
	public Opera getOperaById(int id) {
		
		return operaDao.findById(id).get();
	}

	@Override
	public List<Opera> getOpera() {
		return (List<Opera>) operaDao.findAll();
	}

	@Override
	public void deleteOpera(Opera opera) {
		operaDao.delete(opera);
		
	}

	@Override
	public void createOpera(Opera opera) {
		operaDao.save(opera);
		
	}

	
}
