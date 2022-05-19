package it.pw.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.ProdottoDao;
import it.pw.model.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	ProdottoDao prodottoDao;

	@Override
	public List<Prodotto> vediTutti() {
		
		return prodottoDao.vediTutti();
	}
	
	
	@Override
	public void create(Prodotto p) {
		
		prodottoDao.create(p);
	}

	@Override
	public void update(Prodotto p) {
		prodottoDao.update(p);
		
	}

	@Override
	public void delete(int id) {
		prodottoDao.delete(id);
		
	}


	@Override
	public Prodotto getProdottoById(int id) {
		
		return prodottoDao.getProdottoById(id);
	}

	

		
	
}
