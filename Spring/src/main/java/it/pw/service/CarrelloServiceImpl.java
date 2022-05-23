package it.pw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.CarrelloDao;
import it.pw.model.Carrello;

@Service
public class CarrelloServiceImpl implements CarrelloService {

	@Autowired
	CarrelloDao carrelloDao;
	
	
	@Override
	public void create(Carrello c) {
		carrelloDao.create(c);
		
	}

	
}
