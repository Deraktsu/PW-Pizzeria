package it.pw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.OrdiniDao;
import it.pw.model.Ordine;

@Service
public class OrdiniServiceImpl implements OrdiniService {

	@Autowired
	OrdiniDao ordiniDao;
	
	@Override
	public List<Ordine> vediTutti() {
		
		return ordiniDao.vediTutti();
	}

	@Override
	public void create(Ordine o) {
		ordiniDao.create(o);
		
	}

	@Override
	public void update(Ordine o) {
		ordiniDao.update(o);
		
	}

	@Override
	public void delete(Ordine o) {
		ordiniDao.delete(o);
		
	}

}
