package it.pw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.pw.dao.OrdiniDao;
import it.pw.model.Ordini;

public class OrdiniServiceImpl implements OrdiniService {

	@Autowired
	OrdiniDao ordiniDao;
	
	@Override
	public List<Ordini> vediTutti() {
		
		return ordiniDao.vediTutti();
	}

	@Override
	public void create(Ordini o) {
		ordiniDao.create(o);
		
	}

	@Override
	public void update(Ordini o) {
		ordiniDao.update(o);
		
	}

	@Override
	public void delete(Ordini o) {
		ordiniDao.delete(o);
		
	}

}
